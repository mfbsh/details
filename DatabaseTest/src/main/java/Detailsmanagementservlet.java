

import java.io.IOException;
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
 * Servlet implementation class Detailsmanagementservlet
 */
@WebServlet("/Detailsmanagementservlet")
public class Detailsmanagementservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/testing";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "";
	 private static final String INSERT_USERS_SQL = "INSERT INTO userdetails2" + " (name, date, location, time) VALUES " 
	+
	 " (?, ?, ?, ?);";
	 private static final String SELECT_USERS_BY_ID = "select name,date,location,time from userdetails2 where name =?";
	 private static final String SELECT_ALL_USERS = "select * from userdetails2";
	 private static final String DELETE_USERS_SQL = "delete from userdetails2 where name = ?;";
	 private static final String UPDATE_USERS_SQL = "update userdetails2 set name = ?,date = ?, location = ?, time = ? where name = ?;";
	 protected Connection getConnection() { Connection connection = null;
	 try {
	 Class.forName("com.mysql.jdbc.Driver");
	 connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	 } catch (SQLException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 } catch (ClassNotFoundException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 return connection;
	 }
	 
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Detailsmanagementservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath(); 
		System.out.println("action is " + action);
		
			
		try {
			 switch (action) {
			 case "/Detailsmanagementservlet/new":
			 showNewForm(request, response);
			 break;
			 case "/Detailsmanagementservlet/delete":
			 deleteUser(request, response);
			 break;
			 case "/Detailsmanagementservlet/edit":
			 showEditForm(request, response);
			 break;
			 case "/Detailsmanagementservlet/update":
			 updateUser(request, response);
			 break;
			 default:
			 listUser(request, response);
			 break;
			 }
			 } catch (SQLException ex) {
			 throw new ServletException(ex); 
			 }
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException 
	{
	List < User > users = new ArrayList < > ();
	 try (Connection connection = getConnection();
	 // Step 2:Create a statement using connection object
	 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
	 System.out.println(preparedStatement);
	 // Step 3: Execute the query or update query
	 ResultSet rs = preparedStatement.executeQuery();
	 // Step 4: Process the ResultSet object.
	 while (rs.next()) {
	 String name = rs.getString("name");
	 String date = rs.getString("date");
	 String location = rs.getString("location");
	 String time = rs.getString("time");
	 users.add(new User(name, date, location, time));
	 System.out.println(name);
	 }
	 } catch (SQLException e) {
	 printSQLException(e);
	 }
	//List < User > listUser = databaseOperations.selectAllUsers();
	 
	System.out.println("total details is: " + users.size());
	request.setAttribute("listUser", users);
	RequestDispatcher dispatcher = request.getRequestDispatcher("detailsmanagement.jsp");
	dispatcher.forward(request, response);
	}

	
	//method to redirect to register page
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	RequestDispatcher dispatcher = request.getRequestDispatcher("details.jsp");
	dispatcher.forward(request, response);
	}
	//method to get parameter, query database for existing user data and redirect to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
	System.out.println("comes to showEditForm");
	//get parameter passed in the URL
	 String name = request.getParameter("name");
	User existingUser = new User();//database operation, get data for existing user
	 // Step 1: Establishing a Connection
	 try (Connection connection = getConnection();
	 // Step 2:Create a statement using connection object
	 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID);) {
	 preparedStatement.setString(1, name);
	 System.out.println(preparedStatement);
	 // Step 3: Execute the query or update query
	 ResultSet rs = preparedStatement.executeQuery();
	 // Step 4: Process the ResultSet object.
	 while (rs.next()) {
	 name = rs.getString("name");
	 String date = rs.getString("date");
	 String location = rs.getString("location");
	 String time = rs.getString("time");
	 existingUser = new User(name, date, location, time);
	 }
	 } catch (SQLException e) {
	 printSQLException(e);
	 }
	//Serve up the user-form.jsp
	request.setAttribute("user", existingUser);
	request.getRequestDispatcher("/detailsedit.jsp").forward(request, response);
	//RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
	//dispatcher.forward(request, response);
	}//method to update the user data
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
	System.out.println("comes to updateUser");
	//get values from the request
	String oriName = request.getParameter("oriName");
	 String name = request.getParameter("name");
	 String date = request.getParameter("date");
	 String location = request.getParameter("location");
	 String time = request.getParameter("time");
	 
	 System.out.println(name);
	 System.out.println(date);
	 System.out.println(location);
	 System.out.println(time);
	 
	 //database operation
	 try (Connection connection = getConnection(); PreparedStatement statement = 
	connection.prepareStatement(UPDATE_USERS_SQL);) {
	 statement.setString(1, name);
	 statement.setString(2, date);
	 statement.setString(3, location);
	 statement.setString(4, time);
	 statement.setString(5, oriName);
	 int i = statement.executeUpdate();
	 }
	 
	 //redirect us back to UserServlet !note: do change the url to your project name
	 response.sendRedirect("http://localhost:8085/DatabaseTest/list");
	}//method to delete user
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
	System.out.println("comes to deleteUser");
	 String name = request.getParameter("name");
	 try (Connection connection = getConnection(); PreparedStatement statement = 
	connection.prepareStatement(DELETE_USERS_SQL);) {
	 statement.setString(1, name);
	 int i = statement.executeUpdate();
	 }
	 
	 //redirect us back to UserServlet !note: do change the url to your project name
	 response.sendRedirect("http://localhost:8085/DatabaseTest/list");
	}

	
	
	
	
	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void printSQLException(SQLException ex) {
	    for (Throwable e: ex) {
	        if (e instanceof SQLException) {
	            e.printStackTrace(System.err);
	            System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	            System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	            System.err.println("Message: " + e.getMessage());
	            Throwable t = ex.getCause();
	            while (t != null) {
	                System.out.println("Cause: " + t);
	                t = t.getCause();
	            }
	        }
	    }
	}
}

