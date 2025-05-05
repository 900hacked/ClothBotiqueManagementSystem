package projects.ClothBotiqueManagementSystem.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderItems")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int OrderItemsId;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Orders orders;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Products products;
	
	private int quantity;
	
	private double price;
	
	public OrderItems() {
		
	}

	public OrderItems( Orders orders, Products products, int quantity, double price) {
		
		
		this.orders = orders;
		this.products = products;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderId() {
		return OrderItemsId;
	}

	public void setOrderId(int orderId) {
		OrderItemsId = orderId;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
