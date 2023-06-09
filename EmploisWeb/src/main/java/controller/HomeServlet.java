package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.dao.IDomaine;
import com.groupeisi.entities.Domaine;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/inscription")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private IDomaine domainedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Domaine domaine = new Domaine();
		List<Domaine> domaines = domainedao.list(domaine);
		request.setAttribute("domaines", domaines);
		request.getRequestDispatcher("inscription.jsp").forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
