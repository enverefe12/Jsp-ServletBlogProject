package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccess.TextDao;
import Model.Text;

@WebServlet("/getCategories")
public class GetCategoriesServlet extends HttpServlet {

	private static final long serialVersionUID = -2106974586051663267L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TextDao td=new TextDao();
		List<Text> list=td.getTextByCategory(Integer.valueOf(req.getParameter("categoryId")));
		req.setAttribute("listofTexts", list);
		req.setAttribute("ctgn", req.getParameter("categoryName"));
		req.getRequestDispatcher("showCategory.jsp").forward(req, resp);
	}
	
}
