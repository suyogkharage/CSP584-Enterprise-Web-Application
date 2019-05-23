import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.Serializable;


public class RegisterUserServlet extends HttpServlet implements Serializable {
	
  public static HashMap<String,SmartPortableUser> hm_user = new HashMap<String,SmartPortableUser>();
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    String type = request.getParameter("type");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String uid = request.getParameter("uid");
    String emailid = request.getParameter("emailid");
    String password = request.getParameter("password");
    
    SmartPortableUser newuser = new SmartPortableUser(fname,lname,uid,emailid,password,type);
    hm_user.put(uid, newuser);
    
   	
  
    out.println("<html>");
    out.println("<h3>Successfully Registered as a "+type+" !!</h3>");
    out.println("</html>");
	   //out.println("<a href='Login'>Click Here to Login >");
    response.sendRedirect("Home");

    
  }
  
  
  
}