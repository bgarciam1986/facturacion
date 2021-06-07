package com.facturacion.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "name_product")
	private String nameProduct;
	
	@Column(name = "price_product")
	private Double priceProduct;
	
	@Column(name = "create_at")
	private Date createAt;
	
	public Product() {
		// Constructor vacio
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	
	public Double getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(Double priceProduct) {
		this.priceProduct = priceProduct;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public String toString() {
		return "Product[id="+id+", nameProduct="+nameProduct+", priceProduct="+priceProduct+", createAt="+createAt+"]";
	}
	
	private static final long serialVersionUID = 1L;   

}
