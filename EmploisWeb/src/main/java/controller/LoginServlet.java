package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupeisi.dao.ICompte;
import com.groupeisi.dao.IDomaine;
import com.groupeisi.dao.IEntreprise;
import com.groupeisi.entities.Compte;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICompte logindao;
	@EJB
	private IDomaine domainedao;
	@EJB
	private IEntreprise entreprisedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email").toString();
		String password = request.getParameter("password").toString();
		
		if (logindao.login(email, password)) {
			Compte compte = logindao.byEmail(email);
	        HttpSession session = request.getSession();
	        session.setAttribute("username", compte.getPrenom() +" "+compte.getNom());
	        session.setAttribute("email", email);
	        session.setAttribute("profile", compte.getDroit().getLibelle());
	        String servletPath;
	        if(compte.getDroit().getLibelle().equals("Admin")) {
			    servletPath = "/SamaJob/admin/entreprise";
			    response.sendRedirect(servletPath);
	        }else {
			    servletPath = "/SamaJob/liste/offres";
			    response.sendRedirect(servletPath);
	        	// A compléter
	        }
			
		}else {
			request.setAttribute("error", "erreur");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
