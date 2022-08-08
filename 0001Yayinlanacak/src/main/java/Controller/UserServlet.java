package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccess.UserDao;
import Model.User;

@WebServlet(urlPatterns = {"/checkUser" , "/addUser" , "/logOut"}) 
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1123021812699417279L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			String action = req.getServletPath();
			System.out.println(action);
				switch (action) {
				case "/addUser":
					addUser(req, resp);
					break;
				case "/checkUser":
					checkUser(req, resp);
					break;
				case "/logOut":
					logOut(req, resp);
					break;
				
				}	
			
			
		} catch (ServletException ex) {
			throw new ServletException(ex);
		}
		
	
	}

	/**
	 * Add User Method From {@link AddUserServlet}
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		log("addUser Methoduna Girildi!!!");
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

	/**
	 * Check User for Login {@link CheckUserServlet}
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void checkUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("checkUser Methoduna Girildi!!!");

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

	/**
	 * Log Out the User {@link LogOutServlet}
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		log("logOut Methoduna Girildi!!!");
		
		req.getSession().invalidate();
		req.setAttribute("message", "Çıkış Yapıldı");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
