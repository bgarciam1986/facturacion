package com.facturacion.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "observation")
	private String observation;
	
	@Column(name = "create_at")
	private Date createAt;
	
	// Relacion entre invoice y customer m->n
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	// Relacion en un solo sentido, por eso debemos indicar la columna que se creara automaticamente
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "invoice_id")
	private List<ItemInvoice> items;
	
	public Invoice() {
		// Inicializamos el arreglo de los invoices
		this.items = new ArrayList<ItemInvoice>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getObstevation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<ItemInvoice> getItems(){
		return items;
	}
	public void setItems(List<ItemInvoice> items) {
		this.items = items;
	}
	
	public void addItemInvoice(ItemInvoice item) {
		items.add(item);
	}
	
	// inicializamos una nueva fecha en var createAt
	@PrePersist
	public void prePersist() {
		createAt  = new Date();
	}
	
	public Double getTotal() {
		Double total = 0.0;
		int size = items.size();
		for(int t = 0; t < size; t++) {
			total = total + items.get(t).calculateImport();
		}
		return total;
	}
	
	@Override
	public String toString() {
		return "Customer[id="+id+", description="+description+", observation="+observation+", createAt="+createAt+", customer="+customer+"]";
	}
	
	private static final long serialVersionUID = 1L;
	
	

}
