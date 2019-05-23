import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationParser extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String profilepic = request.getParameter("profilephoto");
		String city = request.getParameter("city");
		String school = request.getParameter("school");
		String usertype = request.getParameter("usertype");
            
        
		String check= new String();
		HashMap<String, Users> hm = new HashMap<String, Users>();

		try
		{
			check = MySQLDataStoreUtilities.getConnection();
			hm=MySQLDataStoreUtilities.selectUser();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		if(check.equals("successfull")) {
			if (hm.containsKey(username+usertype) && hm.get(username+usertype).getUsertype().equals(usertype)) {
				request.setAttribute("Er", "Username Already exists for customer of type "+usertype);
				request.getRequestDispatcher("/Registration").forward(request, response);
	
			} else
			{
				Users user = new Users( username,  firstname,  lastname,  email,  password,  repassword,
						 birthday,  gender,  profilepic,  city,  school,  usertype) ;
				hm.put(username, user);
				try {
				
					MySQLDataStoreUtilities.insertUser(username, firstname, lastname, email, password, repassword, birthday, gender, profilepic, city, school, usertype);
				session.setAttribute("login_msg", "Your "+usertype+" account has been created. Please login");
				request.getRequestDispatcher("/Login").forward(request, response);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}else {
			request.setAttribute("Er", "MySql server is not up and running "+usertype);
			request.getRequestDispatcher("/Registration").forward(request, response);
		}

	}

}