package com.netease;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		login(request, response);
	}
	
	private void login(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		String pw = (String) session.getAttribute("password");
		if(pw != null) {
			session.invalidate();
		}
		else {
			session.setAttribute("password", password);
		}
		Cookie userCookie = new Cookie("user", user);
		userCookie.setMaxAge(30 * 60);
		response.addCookie(userCookie);
		Cookie[] cookies = request.getCookies();
		PrintWriter writer = response.getWriter();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					if(!cookie.getValue().equalsIgnoreCase(user)) {
						writer.println("<html><body>");
						writer.println("<h1>当前用户名与cookie中不一致</h1>"); 
				        writer.println("<h1>用户名：" + user + "</h1>"); 
						writer.println("</body></html>");
						return;
					}
				}
			}
		}
		writer.println("<html><body>");
        writer.println("<h1>用户名：" + user + "</h1>"); 
        writer.println("<h1>密码：" + password + "</h1>"); 
        writer.println("</body></html>");
	}
	
}
