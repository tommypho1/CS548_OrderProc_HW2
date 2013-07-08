package npu.domain;


public class OrderItem {
	private Product product;
	private int quantity;
	
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	//compares the product in the OrderItem
	public boolean isSameProduct(OrderItem item){
		return (item.getProduct().equals(product));
	}
	
	public double getItemTotalPrice(){
		return quantity * product.getPrice();
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
