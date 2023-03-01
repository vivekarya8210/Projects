package com.nt.omt;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class admin extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
//        String duration = request.getParameter("duration");
//        String director = request.getParameter("director");
         
        System.out.println("Username admin: " + Username);
        System.out.println("Password admin: " + Password);
        PrintWriter writer = response.getWriter();
         
        if(Username.equals("shiva") && Password.equals("12345")){
            response.sendRedirect("options.jsp");
        }
        else{
               String htmlResponse = "<html>";
               htmlResponse += "<h2>Invalid Credentials</h2>";        
               htmlResponse += "</html>";
               writer.println(htmlResponse);
        }
         
        // return response
        
         
    }
}