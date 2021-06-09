package com.facturacion.entities;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "paternal_surname")
	private String paternalSurname;
	
	@Column(name = "maternal_surname")
	private String maternalSurname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "create_at")
	private Date createAt;
	
	@Column(name="photo")
	private String photo;
	
	
	// realacion entre clientes y facturas n->m
	@OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	public List<Invoice> invoices;
	
	public Customer() {
		// Constructor vacio, incializa el arreglo de invoices
		invoices = new ArrayList<Invoice>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPaternalSurname() {
		return paternalSurname;
	}
	public void setPaternalSurname(String paternalSurname) {
		this.paternalSurname = paternalSurname;
	}
	
	public String getMaternalSurname() {
		return maternalSurname;
	}
	public void setMaternalSurname(String maternalSurname) {
		this.maternalSurname = maternalSurname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	// Crea nueva fecha en variable
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	// Agrega factura al cliente invoice*invoice
	public void addInvoice(Invoice invoice) {
		invoices.add(invoice);
	}

	@Override
	public String toString() {
		return "Customer[id="+id+", firstName="+firstName+", lastName="+lastName+",paternalSurname="+paternalSurname+",maternalSurname="+maternalSurname+",email="+email+",createAt="+createAt+",photo="+photo+", invoices="+invoices+"]";
	}

}
