import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Detailsservlet
 */
@WebServlet("/Detailsservlet")
public class Detailsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Detailsservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		
		 String n = request.getParameter("name");
		 String p = request.getParameter("date");
		 String e = request.getParameter("location");
		 String t = request.getParameter("time");
		 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection(
		 "jdbc:mysql://localhost:3306/testing", "root", "");
		 PreparedStatement ps = con
		 .prepareStatement("insert into USERDETAILS2 values(?,?,?,?)"); 
		 ps.setString(1, n);
		 ps.setString(2, p);
		 ps.setString(3, e);
		 ps.setString(4, t);
		 
		
		 int i = ps.executeUpdate();
		 response.sendRedirect("http://localhost:8085/DatabaseTest/list");
		 if (i > 0)
		 out.print("You are successfully registered...");
		 } catch (Exception e2) {
		 System.out.println(e2);
		 }
		 out.close();
		 
		
	}

}
