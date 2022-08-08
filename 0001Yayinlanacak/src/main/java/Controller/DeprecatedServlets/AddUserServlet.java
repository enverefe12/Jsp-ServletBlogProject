package Controller.DeprecatedServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccess.UserDao;
import Model.User;

@Deprecated
//@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {

	private static final long serialVersionUID = 8649514747942725615L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String pass=req.getParameter("password");
		UserDao ud=new UserDao();
		List<User> list=ud.getAllUser();
		
		String msg=null;
		String url=null;
		
		for(User u:list) {
			if(u.getUsername().equals(username)) {
				msg="Girilen kullanıcı adı kullanılmaktadır. Lütfen Başka bir kullanıcı adı giriniz.";
				url="register.jsp";
			}
		}
		if(msg==null) {
			ud.addUser(username, pass);
			msg="kullanıcı eklendi, giriş yapınız!";
			url="login.jsp";
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher(url).forward(req, resp);
		
		
	}
}
