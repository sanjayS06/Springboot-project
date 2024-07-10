package com.techpalle.springbootrestmain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techpalle.springbootrestmain.entity.Product;
import com.techpalle.springbootrestmain.service.InventoryService;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {
	private final InventoryService service;
	@Autowired
	public InventoryController( InventoryService service) {
		this.service=service;
		
	}
	
	@PostMapping("/saveproduct")
	
	public ResponseEntity<Product> saveProduct(@RequestBody Product p){
			Product obj=service.saveProduct(p);
			return ResponseEntity.ok(obj);
	}
	//read operation
	@GetMapping("/getproducts")
	public List<Product> getProducts(){
		List<Product> products=service.readAllProducts();
		return products;
	}
	//UPDATE OPERATION
	@PutMapping("/updateproduct/{pno}")
	public Product updateProduct(@PathVariable int pno ,@RequestBody Product np)
	{
		return service.updateProduct(pno, np);
		
	}

	//DELETE OPERATION
	
	@DeleteMapping("/deleteproduct/{pno}")
	public void deleteProduct(@PathVariable int pno)
	{
		service.deleteProduct(pno);
	}
}
