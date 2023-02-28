package com.nt.employee;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public WelcomeServlet() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("admin"); 
	    out.print("<html><body bgcolor=red,text=yellow><center><h1>");
	    out.print("Welcome In"+" "+"ZeOnSoft"+ " "+n);
	    out.print("<br><br><a href=Employee.html>Add Employee</a>");
	    out.print("</h1></center></body></html>");
	    out.close();
		
	}

}
