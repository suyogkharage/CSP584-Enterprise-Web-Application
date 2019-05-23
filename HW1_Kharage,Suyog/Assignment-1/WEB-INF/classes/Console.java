import javax.servlet.http.*;
import java.util.*;

public class Console implements java.io.Serializable{
	public String id;
	public String name;
	public int price;
	public String image;
	public String retailer;
	ArrayList<Accessory> accessories= new ArrayList<Accessory>();
	
	public Console(String id,String name, int price, String image, String retailer,ArrayList<Accessory> accessories){
		this.id=id;
		this.name=name;
		this.price=price;
		this.image=image;
		this.retailer = retailer;
		this.setAccessories(accessories);
	}
	
	public Console(){
		
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
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

	public void setAccessories(ArrayList<Accessory> accessories) {
		this.accessories = accessories;
	}

	public ArrayList<Accessory> getAccessories() {
		return accessories;
	}

		
}
