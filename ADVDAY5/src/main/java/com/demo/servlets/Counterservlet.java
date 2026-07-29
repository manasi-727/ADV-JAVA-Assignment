package com.demo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/getcount")
public class Counterservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    // 1. Read the parameter as raw text
	    String countParam = request.getParameter("count");
	    int cnt = 0; // Default value for the very first visit
	    
	    // 2. SAFE CHECK: Only parse if the parameter actually exists in the URL
	    if (countParam != null && !countParam.trim().isEmpty()) {
	        cnt = Integer.parseInt(countParam);
	    }
	    
	   
	    cnt++;
	    
	    
	    out.println("<h1> You clicked " + cnt + " Times</h1>");
	    // URL Rewriting preserves the count value for the next click
	    out.println("<a href='getcount?count=" + cnt + "'>Click me</a>");
	}


}
