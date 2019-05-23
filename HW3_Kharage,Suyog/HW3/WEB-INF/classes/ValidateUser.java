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
	
	HttpSession session=request.getSession();
	
	
    String uid=request.getParameter("uid");
    String password = request.getParameter("password");
    String category = request.getParameter("category");
	
	String fname=MySqlDataStoreUtilities.ViewUsername(uid);
	
	 if(MySqlDataStoreUtilities.validateUser(uid,password,category))
        {
		
			HttpSession hs=request.getSession();
			hs.setAttribute("fname",fname);
			hs.setAttribute("type",category);
            response.sendRedirect("Home");
			
        }
        else
        {
           out.println("<br><br><h2>Incorrect user id or password or category !</h2><br><br>");
		   out.println("<a href='Login'><h3>Click here to login again</h3>");
        }
	  }
}

   