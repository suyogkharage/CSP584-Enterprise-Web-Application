import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Utilities utility = new Utilities(request, pw);
		System.out.println("Inside Login doGEt");
		utility.printHtml("Header.html");
		//utility.printHtml("LoginHeader.html");
		String errormsg = new String();
		if(session.getAttribute("login_msg")!=null)
				errormsg= session.getAttribute("login_msg").toString();
		if(request.getAttribute("login_msg")!=null)
				errormsg=request.getAttribute("login_msg").toString();
		if(!errormsg.equals("")) {
			pw.println("<section     style=\"text-align: center\">");
			pw.println("<h3 style=\"color:red\">"+errormsg+ "</h3>");
			pw.println("</section>");
			session.removeAttribute("login_msg");
			request.removeAttribute("login_msg");
		}
		utility.printHtml("Login.html");
		utility.printHtml("LoginLeftNav.html");
		utility.printHtml("Footer.html");
	}

}