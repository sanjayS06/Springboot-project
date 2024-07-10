package com.techpalle.springbootrestmain.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techpalle.springbootrestmain.entity.Product;
import com.techpalle.springbootrestmain.repository.InventoryRepository;

@Service
public class InventoryService {
	private final InventoryRepository repository;
	
	@Autowired
	public InventoryService(InventoryRepository repository) {
		this.repository=repository;
	}
	
	public Product saveProduct(Product p) {
		Product obj= repository.save(p);
		return obj;
	}
	//b.Read All Product
	public List<Product> readAllProducts() {
		List<Product> products=repository.findAll();
		return products;
	}
    
	//UPDATE A PRODUCT BASED ON ID
	
	public Product updateProduct(int pno,Product np)
	{ 
		Optional<Product> temp=repository.findById(pno);
		if(temp.isPresent()){
			Product p=temp.get();
			p.setPname(np.getPname());
			p.setPprice(np.getPprice());
			p.setPqty(np.getPqty());
			return repository.save(p);
		}else {
			throw new RuntimeException("product not fount");
		}
			
		}
		

	
	//c.DELETE A PRODUCT BASED ON ID PRIMARY KEY
	public void deleteProduct(int pno) {
		
		repository.deleteById(pno);
	}
}
