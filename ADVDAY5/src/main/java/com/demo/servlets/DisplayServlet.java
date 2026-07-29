package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set the content type using the correct variable name
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Fetch the parameters safely
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		// Display the output
		out.println("<h3>Name : " + name + "</h3>");
		out.println("<h3>Email : " + email + "</h3>");
	}
}
