package Controller.DeprecatedServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Deprecated
//@WebServlet("/logOut")
public class LogOutServlet extends HttpServlet {

	private static final long serialVersionUID = 8927728217910789067L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		req.setAttribute("message", "Çıkış Yapıldı");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
