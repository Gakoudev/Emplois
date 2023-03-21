package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupeisi.dao.IEntreprise;
import com.groupeisi.entities.Entreprise;

/**
 * Servlet implementation class LoginEntrepriseServlet
 */
@WebServlet("/entreprise")
public class LoginEntrepriseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	IEntreprise entrprisedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginEntrepriseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("loginEntreprise.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email").toString();
		String password = request.getParameter("password").toString();
		
		if (entrprisedao.login(email, password)) {
			Entreprise entreprise = entrprisedao.byEmail(email);
	        HttpSession session = request.getSession();
	        session.setAttribute("username", entreprise.getNom());
	        session.setAttribute("email", email);
	        session.setAttribute("profile", "Entreprise");
	        
		    String servletPath = "/SamaJob/entreprise/offres";
		    response.sendRedirect(servletPath);
			
		}else {
			request.setAttribute("erreur", "erreur");
			request.getRequestDispatcher("loginEntreprise.jsp").forward(request, response);
		}
	}

}
