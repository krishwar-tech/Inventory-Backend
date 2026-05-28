package com.inventory.management.service;

import com.inventory.management.entity.Procurement;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ProcurementService {

	Procurement save(
			Long productId,
			Long supplierId,
			Integer qty,
			Double costPrice);

	Map<String, Object> importExcel(
			MultipartFile file);

	List<Procurement> getAll();

	void delete(Long id);

	Procurement updatePayment(
			Long id,
			Double amount);
}