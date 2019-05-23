import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ValidateUser extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    String uid=request.getParameter("uid");
    String password = request.getParameter("password");
    String type = request.getParameter("type");
    //System.out.println(uid);
    //System.out.println(password);
    
    if( (RegisterUserServlet.hm_user.get(uid).getPassword().equals(password))  && (RegisterUserServlet.hm_user.get(uid).getType().equals(type)) )
    {
    	HttpSession hs=request.getSession();
    	hs.setAttribute("fname", RegisterUserServlet.hm_user.get(uid).getFname());
    	hs.setAttribute("type", RegisterUserServlet.hm_user.get(uid).getType());
    	response.sendRedirect("Home");
    }
    else
    {
    	response.sendRedirect("Login");
    }
    
    
    
  }
}