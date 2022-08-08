package Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccess.TextDao;
import Model.Text;

@WebServlet("/fileService.delete")
public class FileDeleteServlet extends HttpServlet{

	private static final long serialVersionUID = 8496897742808906171L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TextDao td=new TextDao();
		Text txt= td.getTextById(Integer.valueOf(req.getParameter("deleteMe")));
		String filePath="Your texts path" +txt.getTextPath();
		boolean result=td.deleteText(Integer.valueOf(req.getParameter("deleteMe")));
		
	     String msg="";
		if(result) {
			msg="Yazı Silindi";
		}else {
		msg="Yazı Silinemedi. Eğer konsolda bir Hata yoksa girilen id de bir yazı bulunmamaktadır.";
		}
				
		File file=new File(filePath);
				
				if(file.exists()) {
					file.delete();
					req.setAttribute("delMessage", "Verilen Dosya Silindi");
				}else {
					req.setAttribute("delMessage", "Dosya Bulunamadı!!");
				}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("secrutiy/deleteBlog.jsp").forward(req, resp);
	}
	
}
