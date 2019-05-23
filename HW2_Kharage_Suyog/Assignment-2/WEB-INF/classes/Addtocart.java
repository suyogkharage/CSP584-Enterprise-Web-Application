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
        Cart ekart;
        ekart = (Cart) session.getAttribute("cart");
        if(ekart == null){
          ekart = new Cart();
          session.setAttribute("cart", ekart);
        }
        String name = request.getParameter("name");
		char c = name.charAt(0);
		Integer price = Integer.parseInt(request.getParameter("price"));
		
		
        ekart.addToCart(name, price);
        session.setAttribute("cart", ekart);     
			
		
		RequestDispatcher rd = request.getRequestDispatcher("Viewcart");
		rd.forward(request,response);
		
	
	
}
}