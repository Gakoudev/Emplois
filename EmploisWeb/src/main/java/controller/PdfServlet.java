package controller;

import java.io.*;
import java.net.URL;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

@WebServlet("/pdf")
public class PdfServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupère le chemin de la page JSP à générer en PDF
        String jspPath = "/test.jsp";

        // Récupère le chemin absolu de la page JSP
        URL resourceUrl = getServletContext().getResource(jspPath);
        String jspAbsolutePath = resourceUrl.getPath();
        //String jspAbsolutePath = getServletContext().getRealPath(jspPath);

        // Crée une instance de la classe ITextRenderer
        ITextRenderer renderer = new ITextRenderer();

        // Charge la page JSP dans le renderer
        renderer.setDocument(jspAbsolutePath);

        // Initialise le renderer
        renderer.layout();

        // Récupère le ServletOutputStream pour écrire le PDF dans la réponse HTTP
        ServletOutputStream outputStream = response.getOutputStream();

        // Écrit le PDF dans le ServletOutputStream
        try {
			renderer.createPDF(outputStream);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Ferme le ServletOutputStream
        outputStream.close();
    }
}
