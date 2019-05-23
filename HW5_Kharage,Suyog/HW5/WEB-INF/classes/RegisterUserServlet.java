import java.io.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;



public class RegisterUserServlet extends HttpServlet{
	
  public static HashMap<String,SmartPortableUser> hm_user = new HashMap<String,SmartPortableUser>();
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
	HttpSession session = request.getSession();

	
    
    String category = request.getParameter("category");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
	String address = request.getParameter("address");
	String city = request.getParameter("city");
	String state = request.getParameter("state");
	String country = request.getParameter("country");
	String zipcode = request.getParameter("zipcode");
	String uid = request.getParameter("uid");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
   
   	MySqlDataStoreUtilities.insertUser(fname,lname,email,address,city,state,country,zipcode,uid,password,category);   	
  
    out.println("<html>");
    out.println("<h3>You are successfully registered as a "+category+" !!</h3>");
    out.println("</html>");
	out.println("<a href='Login'>Click Here to Login");}
  
  

    
  }
  
  
  
