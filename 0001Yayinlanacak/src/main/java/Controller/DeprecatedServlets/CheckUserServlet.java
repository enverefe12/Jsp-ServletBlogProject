package Controller.DeprecatedServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccess.UserDao;
import Model.User;

@Deprecated
//@WebServlet("/checkUser")
public class CheckUserServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		UserDao ud=new UserDao();
		
		String msg="";
		String url="";
		if(ud.getUser(username, password)==null) {
			msg="Kullanıcı Bulunamadı!!!";
			url="login.jsp";
		}else {
			User usr=ud.getUser(username, password);
			req.getSession().setAttribute("userToken", usr.getUsername());
			req.getSession().setAttribute("role", usr.getRole());
            msg="Giriş Yapıldı";
            url="index.jsp";
		}
		req.setAttribute("message", msg);
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
