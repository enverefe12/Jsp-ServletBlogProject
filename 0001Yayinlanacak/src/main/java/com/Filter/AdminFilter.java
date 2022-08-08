package com.Filter;

import java.io.IOException;


import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(dispatcherTypes = {
		DispatcherType.FORWARD,
		DispatcherType.REQUEST,
		DispatcherType.INCLUDE
} , urlPatterns = {"/secrutiy/*"})
public class AdminFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 4806046144481735173L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public AdminFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(((HttpServletRequest) request).getSession().getAttribute("userToken")!=null) {
			if(!((HttpServletRequest) request).getSession().getAttribute("role").equals("admin")) {
				
				((HttpServletResponse) response).sendRedirect(request.getServletContext().getContextPath() +"/invalidUser.jsp");
			}
		}else {
			((HttpServletResponse) response).sendRedirect(request.getServletContext().getContextPath() +"/login.jsp");
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
