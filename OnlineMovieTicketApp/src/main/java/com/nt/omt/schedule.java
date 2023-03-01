package com.nt.omt;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@WebServlet("/schedule")
public class schedule extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String movieId = request.getParameter("movieId");
        String screen = request.getParameter("screen");
        String slot = request.getParameter("slot");
         
        System.out.println("movie: " + movieId);
        System.out.println("genere: " + screen+" "+slot);
 
        // do some processing here...
        try
        {
          // create a mysql database connection
          String myDriver = "com.mysql.cj.jdbc.Driver";
          String myUrl = "jdbc:mysql://localhost:3306/newdb";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "root", "root");
          // the mysql insert statement
          String query = " insert into shows (MId, screen, slot, booked)"
            + " values (?, ?, ?, ?);";

          // create the mysql insert preparedvstatement
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setInt(1, Integer.parseInt(movieId));
          preparedStmt.setInt(2, Integer.parseInt(screen));
          preparedStmt.setInt(3, Integer.parseInt(slot));
          preparedStmt.setInt(4, 0);

          // execute the preparedstatement
          preparedStmt.execute();
          
          conn.close();
          response.sendRedirect("options.jsp");
        }
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
      
    }
 
}