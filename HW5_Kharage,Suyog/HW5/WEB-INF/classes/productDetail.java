
public class productDetail {
	
    private String productName;
    private int price;
    private String retailer;
    private int count;
    private int rebate;
    public productDetail(String pname, int price, String retailer, int count, int rebate ) {
        super();
        this.productName = pname;
        this.price = price;
        this.retailer = retailer;
        this.count = count;
        this.rebate = rebate;
    }
 
    public String getProductName() {
        return productName;
    }
 
    public void setProductName(String pname) {
        this.productName = pname;
    }
 
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
 
    public String getRetailer() {
        return retailer;
    }
    
    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }

    public int getRebate() {
        return rebate;
    }
    
    public void setRebate(int rebate) {
        this.rebate = rebate;
    }

}
