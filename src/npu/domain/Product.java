package npu.domain;

public class Product {
	private String name;
	private double price;
	private String code;
	
	public Product(String name, double price, String code){
		this.name = name;
		this.price = price;
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public int hashCode(){
		return code.hashCode();
	}
	
	@Override
	public boolean equals(Object productObj){
		Product product = (Product) productObj;
		return (product.code.equals(code));
	}
	
	@Override
	public String toString(){	
		String prodStr = String.format("PRODUCT --- Name: %-25s" + "\tPrice: " + price + "\tCode: " + code, name);
		return prodStr;
	}

}
