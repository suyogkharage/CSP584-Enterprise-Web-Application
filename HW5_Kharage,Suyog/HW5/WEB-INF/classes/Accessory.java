


public class Accessory implements java.io.Serializable{
	public String name;
	public int price;
	public String image;
	public String retailer;
	
	
	public Accessory(String name, int price, String image, String retailer){
		this.name=name;
		this.price=price;
		this.image=image;
		this.retailer = retailer;
	}
	
	
	public Accessory() {
		
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


}
