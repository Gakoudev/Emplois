package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.groupeisi.dao.IAnnonce;
import com.groupeisi.dao.ICV;
import com.groupeisi.dao.IDomaine;
import com.groupeisi.dao.IEntreprise;
import com.groupeisi.entities.Annonce;
import com.groupeisi.entities.Domaine;
import com.groupeisi.entities.Entreprise;

/**
 * Servlet implementation class EntrepriseServlet
 */
@WebServlet(urlPatterns = {"/entreprise/offres/liste","/entreprise/offres"})
public class EntrepriseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	IAnnonce annoncedao;
	@EJB
	ICV cvdao;
	@EJB
	IEntreprise entreprisedao;
	@EJB
	IDomaine domainedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntrepriseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Annonce annonce = new Annonce();
		Gson gson = new Gson();
		String jsonData;
		String action = request.getServletPath(); 
		if (action.equals("/entreprise/offres/liste")) {
			List<Annonce> annonces = annoncedao.list(annonce);
			  jsonData = gson.toJson(annonces);
				  
				  // envoyer la réponse JSON au client
				  response.setContentType("application/json");
				  response.setCharacterEncoding("UTF-8");
				  response.getWriter().write(jsonData);
			
		}
		HttpSession session = request.getSession(false);
	        if ((session == null) || session.getAttribute("username") == null) {
	        	response.sendRedirect("index.jsp");
	        }
	        else {
	        	if (session.getAttribute("profile").equals("Entreprise")) {
	        		switch (action) {
        			case "/entreprise/offres":
        				Domaine domaine = new Domaine();
        				List<Domaine> domaines = domainedao.list(domaine);
        				request.setAttribute("domaines", domaines);
        				
        				
        				request.getRequestDispatcher("../WEB-INF/view/entreprise/annonce.jsp").forward(request, response);
        				break;
	        		}
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
	        }
	        else {
	        	if (session.getAttribute("profile").equals("Entreprise")) {
	        		Annonce annonce = new Annonce();
	        		Entreprise entreprise = new Entreprise(); 
	 				int id;
		        	String action = request.getServletPath();
		        	if(action.equals("/entreprise/offres")) {
		        		String titre = request.getParameter("titre");
		        	    String description = request.getParameter("description");
		        	    String localisation = request.getParameter("localisation");
		        	    String salaire = request.getParameter("salaire");
		        	    String dateLimite = request.getParameter("dateLimite");
		        	    String experience = request.getParameter("experience");
		        	    String typeJob = request.getParameter("typeJob");
		        		String domaine1 = request.getParameter("domaine");
		        				        		
		        		entreprise = entreprisedao.byEmail(session.getAttribute("email").toString());
		        		
		        		Domaine domaine = new Domaine();
		        		id = Integer.parseInt(domaine1);
		        		int s = Integer.parseInt(salaire);
		        		domaine = domainedao.get(id, domaine);
		        		annonce.setTitre(titre);
		        		annonce.setDescription(description);
		        		annonce.setLocalisation(localisation);
		        		annonce.setSalaire(s);
		        		annonce.setDateLimite(dateLimite);
		        		annonce.setExperience(experience);
		        		annonce.setTypeJob(typeJob);
		        		annonce.setEntreprise(entreprise);
		        		annonce.setDomaine(domaine);
		        		annoncedao.add(annonce);
        				List<Domaine> domaines = domainedao.list(domaine);
        				request.setAttribute("domaines", domaines);
        				
        				
        				request.getRequestDispatcher("../WEB-INF/view/entreprise/annonce.jsp").forward(request, response);
        			    
		        	}
	        	}
	        }
	}

}
