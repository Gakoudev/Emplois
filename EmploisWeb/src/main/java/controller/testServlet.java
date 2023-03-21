package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class test
 */
@WebServlet(value = "/test", name = "test")
@MultipartConfig
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart("file");
		
        
        // Écriture du fichier sur le serveur
		
		String originalFileName = filePart.getSubmittedFileName();
		String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
		String newFileName = "mon_image_" + fileExtension;

        //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        //InputStream fileContent = filePart.getInputStream();
        //Files.copy(fileContent, new File("C:\\Users\\Lenovo\\Downloads\\" + fileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
        
        // Renvoi du chemin d'accès au fichier en tant que réponse HTTP
		String directoryPath = "C:\\Users\\Lenovo\\Downloads\\";
		String filePath = directoryPath + newFileName;
		File file = new File(filePath);
		try (InputStream fileContent = filePart.getInputStream()) {
		    Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}

        //String filePath = getServletContext().getRealPath( "C:\\Users\\Lenovo\\Downloads\\" + fileName);
		
        response.getWriter().write(filePath);
        
	}

}
