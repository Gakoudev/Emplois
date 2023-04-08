package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.NumberFormat;
import java.util.Locale;

import com.groupeisi.dao.IAnnonce;
import com.groupeisi.dao.ICV;
import com.groupeisi.dao.ICompte;
import com.groupeisi.dao.IDomaine;
import com.groupeisi.dao.IDroit;
import com.groupeisi.entities.Annonce;
import com.groupeisi.entities.CV;
import com.groupeisi.entities.Compte;
import com.groupeisi.entities.Domaine;
import com.groupeisi.entities.Droit;
import com.groupeisi.entities.EmailSender;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

/**
 * Servlet implementation class EmploisServlet
 */
@WebServlet(urlPatterns = {"/liste/offres","/registrer","/postuler/offre","/samaCv/editer","/samaCv/pdf","/offre/details"})
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
	@EJB
	private IAnnonce annoncedao;
       
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
    			switch (action) {
    			case "/postuler/offre":
    				//String email = request.getParameter("email");
    				//request.setAttribute("success", "success");
    				request.getRequestDispatcher("../WEB-INF/view/user/annonce.jsp").forward(request, response);
    				
    				break;
    			case "/liste/offres":
    				request.getRequestDispatcher("../WEB-INF/view/user/annonce.jsp").forward(request, response);
    				
    				break;
    			case "/samaCv/editer":
    				CV cv = new CV();
    				Compte compte = new Compte();
    				compte = comptedao.byEmail(session.getAttribute("email").toString());
    				cv = cvdao.samaCv(compte.getId());
    				request.setAttribute("cv", cv);
    				request.getRequestDispatcher("../WEB-INF/view/user/updatecv.jsp").forward(request, response);
    				break;
    			case "/samaCv/pdf":
    				CV cv2 = new CV();
    				Compte compte2 = new Compte();
    				compte2 = comptedao.byEmail(session.getAttribute("email").toString());
    				cv2 = cvdao.samaCv(compte2.getId());
    				
    				String masterPath = request.getServletContext().getRealPath( "/WEB-INF/cv.pdf" );
    		        response.setContentType( "application/pdf" );
    		        
    		        try ( PdfReader reader = new PdfReader( masterPath );
    			              PdfWriter writer = new PdfWriter( response.getOutputStream() );
    			              PdfDocument document = new PdfDocument( reader, writer ) ) {
    			            
    			            PdfPage page = document.getPage( 1 );
    			            PdfCanvas canvas = new PdfCanvas( page );
    			            
    			            FontProgram fontProgram = FontProgramFactory.createFont();
    			            PdfFont font = PdfFontFactory.createFont( fontProgram, "utf-8" );
    			            NumberFormat formatter = NumberFormat.getNumberInstance( new Locale( "fr", "FR" ) );
    			            
    			            canvas.setFontAndSize( font, 14 );
    			            
    			            canvas.beginText();
    			            
			            	canvas.setTextMatrix( 85, 725 );
			                canvas.showText( "" + cv2.getCompte().getPrenom()+"  " + cv2.getCompte().getNom()+"  " + cv2.getAge()+" ans" );
			                
			                canvas.setFontAndSize( font, 12 );
			            	canvas.setTextMatrix( 85, 703 );
			                canvas.showText( "" + cv2.getCompte().getEmail() );

			            	canvas.setTextMatrix( 85, 675 );
			                canvas.showText( "" + cv2.getAdresse() );
			                
			            	canvas.setTextMatrix( 85, 650 );
			                canvas.showText( "" + cv2.getTelephone() );
			                
			            	canvas.setTextMatrix( 85, 590 );
			                canvas.showText( "" + cv2.getCompte().getDomaine().getNom() );
			                
			            	canvas.setTextMatrix( 85, 525 );
			                canvas.showText( "" + cv2.getSpecialite() );
			                
			            	canvas.setTextMatrix( 85, 460 );
			                canvas.showText( "" + cv2.getNiveauEetude() );
			                
			                String[] lignes = cv2.getExperienceProfessionnelle().split("\n");
			                int top = 400;
			                for (String ligne : lignes) {
			                	ligne = ligne.trim();
				            	canvas.setTextMatrix( 85, top );
				                canvas.showText( "" + ligne);
				                top -= 20;
			                }
			                
			                
			                top -= 20;
    			            
    			            
    			            canvas.endText();
    			            
    			        }
    				break;
    			case "/offre/details":
    				Annonce annonce = new Annonce();

    				int id = Integer.parseInt(request.getParameter("id"));
    				annonce = annoncedao.get(id, annonce);

    				request.setAttribute("annonce", annonce);
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

	    	        if (action.equals("/samaCv/editer")) { 
	    				String adresse = request.getParameter("adresse");
	    				String telephone = request.getParameter("telephone");
	    				String age = request.getParameter("age");
	    				String niveauEtude = request.getParameter("niveauEtude");
	    				String specialite = request.getParameter("specialite");
	    				String experience = request.getParameter("experience");
	    				String email = session.getAttribute("email").toString();
	    				
	    				Compte compte2 = new Compte();
	    				compte2 = comptedao.byEmail(session.getAttribute("email").toString());
	    				CV cv = cvdao.samaCv(compte2.getId());
	    				cv.setAdresse(adresse);
	    				cv.setAge(age);
	    				cv.setTelephone(telephone);
	    				cv.setNiveauEetude(niveauEtude);
	    				cv.setExperienceProfessionnelle(experience);
	    				cv.setSpecialite(specialite);
	    				cvdao.update(cv);
	    				try {
	    					EmailSender.sendEmail(email, "Mis à jours", "La mis à jours de votre cv a été effectuée avec succés");
	    				} catch (MessagingException e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
	    			    String servletPath = "/SamaJob/login";
	    			    response.sendRedirect(servletPath);
	    			}
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
