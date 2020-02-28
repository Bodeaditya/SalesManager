package com.sale;

public class Sale {
	
	private int id;
	private String item;
	private int quantity;
	private int amount;
	private byte[] image;
	
	public Sale() {
		
	}
	public Sale(String item, int quantity, int amount , byte[] image) {
		super();
		this.item = item;
		this.quantity = quantity;
		this.amount = amount;
		this.image = image;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public byte[] getImage() {
		
		return image;
	}
	public void setImage(byte[] image){
		
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Sale [id=" + id + ", item=" + item + ", quantity=" + quantity + ", amount=" + amount + ", image=" + image + "]";
	}
	
	
}
