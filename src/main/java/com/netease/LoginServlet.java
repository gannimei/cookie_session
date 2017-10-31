package com.netease;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
        writer.println("<h1>用户名：" + user + "</h1>"); 
        writer.println("<h1>密码：" + password + "</h1>"); 
        writer.println("</body></html>");
	}

}
