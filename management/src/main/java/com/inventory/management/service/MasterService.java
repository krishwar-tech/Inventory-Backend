package com.inventory.management.service;

import com.inventory.management.entity.Category;
import com.inventory.management.entity.Customer;
import com.inventory.management.entity.Supplier;

import java.util.List;
import java.util.Map;

public interface MasterService {

	List<Map<String, Object>> getCategories();

	Category addCategory(Category c);

	Category updateCategory(Long id, Category body);

	String deleteCategory(Long id);

	List<Supplier> getSuppliers();

	Supplier addSupplier(Supplier s);

	Supplier updateSupplier(Long id, Supplier body);

	String deleteSupplier(Long id);

	List<Customer> getCustomers();

	Customer addCustomer(Customer c);

	Customer updateCustomer(Long id, Customer body);

	void deleteCustomer(Long id);
}