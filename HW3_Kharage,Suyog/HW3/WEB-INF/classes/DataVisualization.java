import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


public class DataVisualization extends HttpServlet 
{	 
	 public DataVisualization() 
	 {
	  super();
	 }

	 protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	 {
		MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
		List<productDetail> productDetailsList = null;
		try {
			productDetailsList = obj.getInventoryTable();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		  Gson gson = new Gson();
		  String jsonString = gson.toJson(productDetailsList);
		  response.setContentType("application/json");
		  response.getWriter().write(jsonString);

	 }
	 
	  protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	 {
		
    		List<productDetail> list = null;
			HashMap<String,Integer> hash = new HashMap<String,Integer>(); 
			//HashMap<String,Integer> hash1 = new HashMap<String,Integer>(); 
			int soldCount = 0;
						
			try {
				list = MySqlDataStoreUtilities.getInventoryTable();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			for(int i=0; i < list.size(); i++)
			{
				productDetail pd = list.get(i);
				try {soldCount = MySqlDataStoreUtilities.getSoldCount(pd.getProductName());} 
				catch (SQLException e) {e.printStackTrace();}
				hash.put(pd.getProductName(),soldCount);
			}
			int j=0;
		  
			List<forJsonSalesBarChart> obj1 = new ArrayList<forJsonSalesBarChart>();

			for(Map.Entry<String, Integer> entry : hash.entrySet()) {
							
							String key = entry.getKey();
							int value = entry.getValue();
								
							productDetail pd = list.get(j);
													
							forJsonSalesBarChart forBarChartObj = new forJsonSalesBarChart();
							forBarChartObj.setproductName(key);
							forBarChartObj.setTotalSales(value*pd.getPrice());
							obj1.add(forBarChartObj);		
							
							j++;
			}
			
		  
	/*	  MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
		List<String> productnamescustorders = obj.getallproductnamescustorders();
		List<forJsonSalesBarChart> obj1 = new ArrayList<forJsonSalesBarChart>();
		
		for(String name:productnamescustorders)
		{
			int count = obj.getCount(name);
			double price = obj.getprice(name);
			double totalsales = count*price;
			
			forJsonSalesBarChart forBarChartObj = new forJsonSalesBarChart();
			forBarChartObj.setproductName(name);
			forBarChartObj.setTotalSales(totalsales);
			obj1.add(forBarChartObj);		
			
		}
		*/ 
		  Gson gson = new Gson();
		  String jsonString = gson.toJson(obj1);
		  response.setContentType("application/json");
		  response.getWriter().write(jsonString);
		 
	 }
}


class forJsonSalesBarChart
{
	String productName; 
	double totalSales;
	
	public void setproductName(String productName)
	{
		this.productName = productName;
	}
	public void setTotalSales(double totalSales)
	{
		this.totalSales = totalSales;
	}
	
	public String getproductName()
	{
		return this.productName;
	}
	public double getTotalSales()
	{
		return this.totalSales;
	}
}