import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

public class Carousel {
	
	public String carouselfeature(String username)
	{
		
	    String userName = username;
	   
	    ProductRecommenderUtility prodRecUtility = new ProductRecommenderUtility();
		
		HashMap<String, Product> hm = new HashMap<String, Product>();
		StringBuilder sb = new StringBuilder();
		String myCarousel = null;
			
		String name = null;
		String CategoryName = null;
		if(CategoryName==null){
			try{
			hm=MySqlDataStoreUtilities.getData();
			name = "";
			}catch(Exception e)
			{
				
			}
			
		}
		HashMap<String,String> prodRecmMap = new HashMap<String,String>();
		prodRecmMap = prodRecUtility.readOutputFile();
		
		
		
		for(String user: prodRecmMap.keySet())
		{
			if(user.equals(userName))
			{
				String products = prodRecmMap.get(user);
				products=products.replace("[","");
				products=products.replace("]","");
				products=products.replace("\"", " ");
				ArrayList<String> productsList = new ArrayList<String>(Arrays.asList(products.split(",")));

					
				sb.append("<div id='content'><div class='post'><h2 class='title meta'>");
				sb.append("<a style='font-size: 24px;'>"+""+" Recommended Products</a></h2></div></div>");
				
				
				sb.append("<br><br><div align='center'>");
				sb.append("<div class='carousel slide' id='myCarousel' data-ride='carousel'>");
				sb.append("<div class='carousel-inner'>");
						
				int k = 0;
				for(String prod : productsList){
					prod= prod.replace("'", "");
					Product prodObj = new Product();
					prodObj = ProductRecommenderUtility.getProduct(prod.trim());
					if (k==0 )
					{	sb.append("<div class='item active'>");
					}
					else
					{	sb.append("<div class='item'>");
					}
					sb.append("<h3>"+prodObj.getName()+"</h3>");
					sb.append("<strong>"+prodObj.getPrice()+"$</strong>");
					sb.append("<img src='images/"+prodObj.getImage()+"' alt='' />");
					sb.append("<form method='post' action='Cart'>" +
							"<input type='hidden' name='name' value='"+prod.trim()+"'>"+
							"<input type='hidden' name='type' value='"+prodObj.getCategory()+"'>"+
							"<input type='hidden' name='maker' value='"+prodObj.getRetailer()+"'>"+
							"<input type='hidden' name='access' value='"+" "+"'>"+
							"<input type='submit' class='btnbuy' value='Buy Now'></form>");
					sb.append("<form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='"+prodObj.getName()+"'>"+
							"<input type='hidden' name='type' value='"+prodObj.getCategory()+"'>"+
							"<input type='hidden' name='maker' value='"+prodObj.getRetailer()+"'>"+
							"<input type='hidden' name='access' value='"+" "+"'>"+
							"<input type='hidden' name='price' value='"+prodObj.getPrice()+"'>"+
							"<input type='submit' value='WriteReview' class='btnreview'></form>");
					sb.append("<form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+prodObj.getName()+"'>"+
							"<input type='hidden' name='type' value='"+prodObj.getCategory()+"'>"+
							"<input type='hidden' name='maker' value='"+prodObj.getRetailer()+"'>"+
							"<input type='hidden' name='access' value='"+" "+"'>"+
							"<input type='submit' value='ViewReview' class='btnreview'></form>");

					sb.append("");
					sb.append("</div>");
				
					k++;
					
				}
				
			
				sb.append("</div>");
				sb.append("</div>");
			
				sb.append("</div>");
			
			
				}
			}
			return sb.toString();
		}
	}
	

