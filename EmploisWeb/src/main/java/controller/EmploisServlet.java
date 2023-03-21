package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.groupeisi.dao.ICV;
import com.groupeisi.dao.ICompte;
import com.groupeisi.dao.IDomaine;
import com.groupeisi.dao.IDroit;
import com.groupeisi.entities.CV;
import com.groupeisi.entities.Compte;
import com.groupeisi.entities.Domaine;
import com.groupeisi.entities.Droit;
import com.groupeisi.entities.EmailSender;
import com.groupeisi.entities.Entreprise;

/**
 * Servlet implementation class EmploisServlet
 */
@WebServlet(urlPatterns = {"/liste/offres","/registrer","/postuler/offre","/samaCv/editer","/offres/liste","/offre/details"})
public class EmploisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private IDomaine domainedao;
	@EJB
	private ICompte comptedao;
	@EJB
	private ICV cvdao;
	@EJB
	private IDroit droitdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmploisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        if ((session == null) || session.getAttribute("username") == null) {
        	response.sendRedirect("index.jsp");
        }
        else {
        	if ((session != null) && session.getAttribute("profile").equals("User")) {
        		String action = request.getServletPath();
	        	Entreprise entreprise = new Entreprise();
				Domaine domaine = new Domaine();
				Gson gson = new Gson();
    			switch (action) {
    			case "/postuler/offre":
    				request.getRequestDispatcher("../WEB-INF/view/user/annonce.jsp").forward(request, response);
    				
    				break;
    			case "/liste/offres":
    				request.getRequestDispatcher("../WEB-INF/view/user/annonce.jsp").forward(request, response);
    				
    				break;
    			case "editerCv":

    				break;
    			case "/offre/details":
    				request.getRequestDispatcher("../WEB-INF/view/user/annoncedetail.jsp").forward(request, response);
    				break;
    			default:
    				break;
    			}
        	}
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		 HttpSession session = request.getSession(false);
	        if ((session == null) || session.getAttribute("username") == null) {
	        	response.sendRedirect("index.jsp");
	        }
	        else {
	        	if ((session != null) && session.getAttribute("profile").equals("Entreprise")) {
	        		
	        	}
	        }
	        if (action.equals("/registrer")) { 
				String nom = request.getParameter("nom");
				String prenom =  request.getParameter("prenom");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String adresse = request.getParameter("adresse");
				String telephone = request.getParameter("telephone");
				String domaine = request.getParameter("domaine");
				String age = request.getParameter("age");
				String niveauEtude = request.getParameter("niveauEtude");
				String specialite = request.getParameter("specialite");
				String experience = request.getParameter("experience");
				Compte c = new Compte();
				Domaine d = new Domaine();
				d = domainedao.get(Integer.parseInt(domaine), d);
				Droit droit = new Droit();
				droit = droitdao.get(2, droit);
				c.setDroit(droit);
				c.setDomaine(d);
				c.setEmail(email);
				c.setNom(nom);
				c.setPrenom(prenom);
				c.setPassword(password);
				comptedao.add(c);
				CV cv = new CV();
				cv.setAdresse(adresse);
				cv.setAge(age);
				cv.setTelephone(telephone);
				cv.setCompte(comptedao.byEmail(email));
				cv.setSpecialite(specialite);
				cv.setNiveauEetude(niveauEtude);
				cv.setExperienceProfessionnelle(experience);
				cv.setSpecialite(specialite);
				cvdao.add(cv);
				try {
					EmailSender.sendEmail(email, "Bienvenue", "Bienvenue dans SamaJob. Votre CV est enregistré avec succés");
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    String servletPath = "/SamaJob/login";
			    response.sendRedirect(servletPath);
				
	        }
	}

}
