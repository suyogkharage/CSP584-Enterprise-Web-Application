import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class SignOut extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
    
    session.invalidate();
    
    response.sendRedirect("Home");
    
    
  }
  
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
    
    session.invalidate();
    
    response.sendRedirect("Home");
    
    
  }
}