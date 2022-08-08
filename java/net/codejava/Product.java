package net.codejava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
	creates product object as well as charactertistics of the product, such as id, Sku,
	productName, productDescription, productPrice, as well as the getters and setters for 
	the object
*/
@Entity
@Table(name = "orders")
public class Product {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length=20)
	private String Sku;
	
	@Column(nullable = false, unique = true, length= 20)
	private String productName;
	
	@Column(nullable = false, length = 50)
	private String productDescription;
	
	@Column(nullable = false,  length = 10)
	private float productPrice;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSku() {
		return Sku;
	}
	public void setSku(String Sku) {
		this.Sku = Sku;
	}
	public String getproductName() {
		return productName;
	}
	public void setproductName(String productName) {
		this.productName = productName;
	}
	public String getproductDescription() {
		return productDescription;
	}
	public void setproductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Float getproductPrice() {
		return productPrice;
	}
	public void setproductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}
}
