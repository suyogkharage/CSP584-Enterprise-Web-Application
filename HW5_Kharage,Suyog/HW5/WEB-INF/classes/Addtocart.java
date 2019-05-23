import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



public class Addtocart extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
        
      HttpSession session = request.getSession();
        String name = request.getParameter("name");
        Integer price = Integer.parseInt(request.getParameter("price"));
        
        Cart ekart;
        int count=0;
        
        count = MySqlDataStoreUtilities.getproductCount(name);
        
        if(count>0)
        {
            ekart = (Cart) session.getAttribute("cart");
            if(ekart == null){
              ekart = new Cart();
              session.setAttribute("cart", ekart);
            }
            
    		char c = name.charAt(0);
    		
    		session.setAttribute("currentCount", count);
    		
            ekart.addToCart(name, price);
            session.setAttribute("cart", ekart);     
    			
    		
    		RequestDispatcher rd = request.getRequestDispatcher("Viewcart");
    		rd.forward(request,response);
        }
        else
        {
        	int code=1;	
        	session.setAttribute("Code", code);
        	response.sendRedirect("Done");
        }
 
		
	
	
}
}