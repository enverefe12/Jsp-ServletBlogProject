package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import DataAccess.TextDao;

@WebServlet("/fileService.upload")
public class FileUploadServlet extends HttpServlet{

	private static final long serialVersionUID = -6965287834105194978L;
	
	private final String UPLOAD_DIRECTORY = "Your texts path";


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		
		int catId=(int) session.getAttribute("catId");
		String textName=(String) session.getAttribute("textName");
		String textPath=(String) session.getAttribute("textPath");
		if (ServletFileUpload.isMultipartContent(req)) {
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload fileUpload = new ServletFileUpload(factory);
				List<FileItem> multiparts = fileUpload.parseRequest(req);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
					}
				}
				// File uploaded successfully
				req.setAttribute("message", "Dosya Başarı ile Yüklendi. Lütfen tekrar giriş yapınız.");
				TextDao td=new TextDao();
				td.addText(textName, textPath, catId);
			} catch (Exception ex) {
				req.setAttribute("message", "Dosya işlemi esnasında bir hata oluştu: " + ex);
				ex.printStackTrace();
			}
			

		} else {
			req.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}
		req.getRequestDispatcher("secrutiy/addBlog.jsp").forward(req, resp);
		
	}
}
