 package com.facturacion.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_invoices")
public class ItemInvoice implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "amount")
	private Integer amount;
	
	public ItemInvoice() {
		// Constructor vacio
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public void calculateImport() {
		this.amount.longValue();
	}
	
	@Override
	public String toString() {
		return "itemInvoice[id="+id+", amount="+amount+"]";
	}
	
	private static final long serialVersionUID = 1L;

}
