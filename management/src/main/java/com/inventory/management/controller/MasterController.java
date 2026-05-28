package com.inventory.management.controller;

import com.inventory.management.dto.ApiResponse;
import com.inventory.management.entity.Category;
import com.inventory.management.entity.Customer;
import com.inventory.management.entity.Supplier;
import com.inventory.management.service.MasterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/masters")
public class MasterController {

	private final MasterService service;

	public MasterController(MasterService service) {
		this.service = service;
	}

	// CATEGORY

	@GetMapping("/categories")
	public ResponseEntity<ApiResponse<List<Map<String, Object>>>> getCategories() {

		List<Map<String, Object>> categories =
				service.getCategories();

		ApiResponse<List<Map<String, Object>>> response =
				new ApiResponse<>(
						true,
						"Categories fetched successfully",
						HttpStatus.OK.value(),
						categories,
						LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@PostMapping("/categories")
	public ResponseEntity<ApiResponse<Category>> addCategory(
			@RequestBody Category c) {

		Category saved = service.addCategory(c);

		ApiResponse<Category> response =
				new ApiResponse<>(
						true,
						"Category added successfully",
						HttpStatus.CREATED.value(),
						saved,
						LocalDateTime.now());

		return new ResponseEntity<>(
				response,
				HttpStatus.CREATED);
	}

	@PutMapping("/categories/{id}")
	public ResponseEntity<ApiResponse<Category>> updateCategory(
			@PathVariable Long id,
			@RequestBody Category c) {

		Category updated =
				service.updateCategory(id, c);

		ApiResponse<Category> response =
				new ApiResponse<>(
						true,
						"Category updated successfully",
						HttpStatus.OK.value(),
						updated,
						LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/categories/{id}")
	public ResponseEntity<ApiResponse<String>> deleteCategory(
			@PathVariable Long id) {

		String result = service.deleteCategory(id);

		ApiResponse<String> response =
				new ApiResponse<>(
						true,
						"Category deleted successfully",
						HttpStatus.OK.value(),
						result,
						LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	// SUPPLIER

	@GetMapping("/suppliers")
	public ResponseEntity<ApiResponse<List<Supplier>>> getSuppliers() {

		List<Supplier> suppliers =
				service.getSuppliers();

		ApiResponse<List<Supplier>> response =
				new ApiResponse<>(
						true,
						"Suppliers fetched successfully",
						HttpStatus.OK.value(),
						suppliers,
						LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@PostMapping("/suppliers")
	public ResponseEntity<ApiResponse<Supplier>> addSupplier(
			@RequestBody Supplier s) {

		Supplier saved = service.addSupplier(s);

		ApiResponse<Supplier> response =
				new ApiResponse<>(
						true,
						"Supplier added successfully",
						HttpStatus.CREATED.value(),
						saved,
						LocalDateTime.now());

		return new ResponseEntity<>(
				response,
				HttpStatus.CREATED);
	}

	@PutMapping("/suppliers/{id}")
	public ResponseEntity<ApiResponse<Supplier>> updateSupplier(
			@PathVariable Long id,
			@RequestBody Supplier s) {

		Supplier updated =
				service.updateSupplier(id, s);

		ApiResponse<Supplier> response =
				new ApiResponse<>(
						true,
						"Supplier updated successfully",
						HttpStatus.OK.value(),
						updated,
						LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/suppliers/{id}")
	public ResponseEntity<ApiResponse<String>> deleteSupplier(
			@PathVariable Long id) {

		String result = service.deleteSupplier(id);

		ApiResponse<String> response =
				new ApiResponse<>(
						true,
						"Supplier deleted successfully",
						HttpStatus.OK.value(),
						result,
						LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	// CUSTOMER

	@GetMapping("/customers")
	public ResponseEntity<ApiResponse<List<Customer>>> getCustomers() {

		List<Customer> customers =
				service.getCustomers();

		ApiResponse<List<Customer>> response =
				new ApiResponse<>(
						true,
						"Customers fetched successfully",
						HttpStatus.OK.value(),
						customers,
						LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@PostMapping("/customers")
	public ResponseEntity<ApiResponse<Customer>> addCustomer(
			@RequestBody Customer c) {

		Customer saved = service.addCustomer(c);

		ApiResponse<Customer> response =
				new ApiResponse<>(
						true,
						"Customer added successfully",
						HttpStatus.CREATED.value(),
						saved,
						LocalDateTime.now());

		return new ResponseEntity<>(
				response,
				HttpStatus.CREATED);
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<ApiResponse<Customer>> updateCustomer(
			@PathVariable Long id,
			@RequestBody Customer c) {

		Customer updated =
				service.updateCustomer(id, c);

		ApiResponse<Customer> response =
				new ApiResponse<>(
						true,
						"Customer updated successfully",
						HttpStatus.OK.value(),
						updated,
						LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteCustomer(
			@PathVariable Long id) {

		service.deleteCustomer(id);

		ApiResponse<Void> response =
				new ApiResponse<>(
						true,
						"Customer deleted successfully",
						HttpStatus.OK.value(),
						null,
						LocalDateTime.now());

		return ResponseEntity.ok(response);
	}
}