package com.facturacion.dao;

import java.util.List;

import com.facturacion.entities.Customer;

public interface IClienteDao {
	
	public List<Customer> findAll();

}
