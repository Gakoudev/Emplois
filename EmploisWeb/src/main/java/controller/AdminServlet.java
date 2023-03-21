package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import com.groupeisi.dao.IDomaine;
import com.groupeisi.dao.IEntreprise;
import com.groupeisi.entities.Domaine;
import com.groupeisi.entities.Entreprise;


/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(urlPatterns = {"/admin/entreprise","/admin/domaine","/admin/domaine/delete","/admin/entreprise/edit","/admin/domaine/liste","/admin/entreprise/liste"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private IDomaine domainedao;
	@EJB
	private IEntreprise entreprisedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession session = request.getSession(false);
        if ((session == null) || session.getAttribute("username") == null) {
        	response.sendRedirect("index.jsp");
        }else {
        	 if ((session != null) && session.getAttribute("profile").equals("Admin")) {
        			String action = request.getServletPath();
    	        	Entreprise entreprise = new Entreprise();
    				Domaine domaine = new Domaine();
    				Gson gson = new Gson();
        			switch (action) {
        			case "/admin/entreprise":
        				List<Domaine> domaines = domainedao.list(domaine);
        				request.setAttribute("domaines", domaines);
        				request.getRequestDispatcher("../WEB-INF/view/admin/entreprise.jsp").forward(request, response);
        				
        				break;
        			case "/admin/entreprise/liste":
        				List<Entreprise> entreprises = entreprisedao.list(entreprise);
      				  String jsonData = gson.toJson(entreprises);
      				  
      				  // envoyer la réponse JSON au client
      				  response.setContentType("application/json");
      				  response.setCharacterEncoding("UTF-8");
      				  response.getWriter().write(jsonData);
        				
        				break;
        			case "/admin/entreprise/edit":
        				int id = Integer.parseInt(request.getParameter("idE"));
        				entreprise = entreprisedao.get(id, entreprise);
        				if(entreprise != null) {
        					
        					JSONObject obj = new JSONObject();
        					obj.put("nomE", entreprise.getNom());
        					obj.put("adresseE", entreprise.getAdresse());
        					obj.put("emailE", entreprise.getEmail());
        					obj.put("siteWebE", entreprise.getSiteWeb());
        					obj.put("telephoneE", entreprise.getTelephone());
        					obj.put("id", entreprise.getId());
        					StringWriter out = new StringWriter();
        				    obj.writeJSONString(out);
        				      
        				      String jsonText = out.toString();

        						PrintWriter pout = response.getWriter();
        						pout.println(jsonText);
        				      System.out.print(jsonText);
        				}
        				break;
        			case "/admin/domaine":
        				/*
        				Domaine domaine = new Domaine();
        				List<Domaine> domaines = domainedao.list(domaine);
        				request.setAttribute("domaines", domaines);
	       				request.getRequestDispatcher("../WEB-INF/view/admin/domaine.jsp").forward(request, response);
        				*/


  	       				request.getRequestDispatcher("../WEB-INF/view/admin/domaine.jsp").forward(request, response);
        				break;
        			case "/admin/domaine/liste":
        				/*
        				Domaine domaine = new Domaine();
        				List<Domaine> domaines = domainedao.list(domaine);
        				request.setAttribute("domaines", domaines);
	       				request.getRequestDispatcher("../WEB-INF/view/admin/domaine.jsp").forward(request, response);
        				*/


        				Domaine domaine1 = new Domaine();
        				List<Domaine> domaines1 = domainedao.list(domaine1);
        				Gson gson1 = new Gson();
        				  String jsonData1 = gson1.toJson(domaines1);
        				  
        				  // envoyer la réponse JSON au client
        				  response.setContentType("application/json");
        				  response.setCharacterEncoding("UTF-8");
        				  response.getWriter().write(jsonData1);
        				break;
        			default:
        				break;
        			}
             }else {

     			//A completer
             }
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if ((session == null) || session.getAttribute("username") == null) {
        	response.sendRedirect("index.jsp");
        }else {
        	 if (session.getAttribute("profile").equals("Admin")) {

 					PrintWriter out = response.getWriter();
        			String action = request.getServletPath();
        			switch (action) {
        			case "/admin/entreprise":
        				String nom = request.getParameter("nom");
        				String description =  request.getParameter("description");
        				String adresse = request.getParameter("adresse");
        				String email = request.getParameter("email");
        				String siteWeb = request.getParameter("siteWeb");
        				String telephone = request.getParameter("telephone");
        				String domain = request.getParameter("domaine");
        				Domaine domaine = new Domaine();
        				Entreprise e = new Entreprise(); 
        				e.setNom(nom);
        				e.setDescription(description);
        				e.setAdresse(adresse);
        				e.setEmail(email);
        				e.setSiteWeb(siteWeb);
        				e.setTelephone(telephone);
        				e.setDomaine(domainedao.get(Integer.parseInt(domain), domaine));
        				e.setPassword("passer");
        				entreprisedao.add(e);
        				out.println("Entreprise ajouter avec succés.");
        			    response.setStatus(HttpServletResponse.SC_OK);
        				//ajout
        				break;
        			case "/admin/entreprise/edit":
        				int idE = Integer.parseInt(request.getParameter("idE"));
        				Entreprise e2 = new Entreprise();
        				e2 = entreprisedao.get(idE, e2);

        				String nom2 = request.getParameter("nomE");
        				String adresse2 = request.getParameter("adresseE");
        				String email2 = request.getParameter("emailE");
        				String siteWeb2 = request.getParameter("siteWebE");
        				String telephone2 = request.getParameter("telephoneE");
        				String domain2 = request.getParameter("domaineE");
        				Domaine domaine2 = new Domaine();
        				
        				e2.setNom(nom2);
        				e2.setAdresse(adresse2);
        				e2.setEmail(email2);
        				e2.setSiteWeb(siteWeb2);
        				e2.setTelephone(telephone2);
        				e2.setDomaine(domainedao.get(Integer.parseInt(domain2), domaine2));
        				entreprisedao.update(e2);
        				out.println("Entreprise mis à jours avec succés.");
        			    response.setStatus(HttpServletResponse.SC_OK);
        				
        			
        				break;
        			case "/admin/domaine/delete":
        				String id = request.getParameter("idD");
        				Domaine d2 = new Domaine();
        				domainedao.delete(Integer.parseInt(id), d2);
        				out.println("Domaine supprimer avec succés.");
        			    response.setStatus(HttpServletResponse.SC_OK);
        				break;
        			case "/admin/domaine":
        				String name = (String) request.getParameter("nom");
        				Domaine d = new Domaine();
        				d.setNom(name);
        				domainedao.add(d);
        				out.println("Domaine ajouter avec succés.");
        			    response.setStatus(HttpServletResponse.SC_OK);
        				//ajout
        				break;
        			default:
        				break;
        			}
             }else {

     			//A completer
             }
        }
	}

}
