import javax.servlet.http.*;
import java.util.*;

public class Product implements java.io.Serializable{
	public String id;
	public String name;
	public int price;
	public String image;
	public String retailer;
	public String condition;
	public String onsale;
	public int rebate;
	public int quantity;
	public String category;
	ArrayList<Accessory> accessories= new ArrayList<Accessory>();
	
	public Product(String id,String name, int price, String image, String retailer,String condition,int rebate,int quantity,String onsale,ArrayList<Accessory> accessories){
		this.id=id;
		this.name=name;
		this.price=price;
		this.image=image;
		this.retailer = retailer;
		this.condition = condition;
		this.rebate = rebate;
		this.quantity = quantity;
		this.onsale = onsale;
		this.setAccessories(accessories);
	}
	
	public Product(String name,String category, int price, String image, String retailer,String condition,int rebate,int quantity,String onsale){
		
		this.name=name;
		this.category = category;
		this.price=price;
		this.image=image;
		this.retailer = retailer;
		this.condition = condition;
		this.rebate = rebate;
		this.quantity = quantity;
		this.onsale = onsale;
		
	}
	
	
	
	public Product(){
		
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category=category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRetailer() {
		return retailer;
	}
	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getOnsale() {
		return onsale;
	}
	public void setOnsale(String onsale) {
		this.onsale = onsale;
	}

	public int getRebate() {
		return rebate;
	}
	public void setRebate(int rebate) {
		this.rebate = rebate;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setAccessories(ArrayList<Accessory> accessories) {
		this.accessories = accessories;
	}

	public ArrayList<Accessory> getAccessories() {
		return accessories;
	}

		
}
