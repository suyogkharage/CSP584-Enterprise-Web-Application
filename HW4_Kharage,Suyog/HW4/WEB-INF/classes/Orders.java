import java.io.*;
import java.util.*;

public class Orders {
	
	int oid;
	String firstName;
	String productName;
	double totalamount;
	String address;
	String city;
	String country;
	int zipcode;
	long creditcardnumber;
	String orderdate;
	String deliverydate;
	
	public Orders(int oid,String firstName, String productName, double totalamount, String orderDate, String deliveryDate,String address)
	{
		this.oid=oid;
		this.firstName=firstName;
		this.productName=productName;
		this.totalamount=totalamount;
		this.address=address;
		this.orderdate=orderDate;
		this.deliverydate=deliveryDate;
		
		
		
	}
	
		public int getoid() {
			return oid;
		}

		public void setoid(int oid) {
			this.oid = oid;
		}

		
		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}
		
		public double getTotalamount() {
			return totalamount;
		}

		public void setTotalamount(double totalamount) {
			this.totalamount = totalamount;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		
		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}
		
		public int getZipcode() {
			return zipcode;
		}

		public void setZipcode(int zipcode) {
			this.zipcode = zipcode;
		}
		
		public long getCreditcardnumber() {
			return creditcardnumber;
		}

		public void setCreditcardnumber(long creditcardnumber) {
			this.creditcardnumber = creditcardnumber;
		}
		
		
		public String getOrderdate() {
			return orderdate;
		}

		public void setOrderdate(String orderdate) {
			this.orderdate = orderdate;
		}
		
		public String getDeliverydate() {
			return deliverydate;
		}

		public void setDeliverydate(String deliverydate) {
			this.deliverydate = deliverydate;
		}
		
}

	
	