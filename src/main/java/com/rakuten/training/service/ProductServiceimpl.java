package com.rakuten.training.service;
//import com.rakuten.training.domain.Product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ProductDAOJpaImpl;
//import com.rakuten.training.dal.ProductDAOInMemimpl;
import com.rakuten.training.domain.Product;

@Service
public class ProductServiceimpl implements ProductService{
	
	
	ProductDAO dao ;//=new ProductDAOJpaImpl();
	@Autowired
	public void setDao(ProductDAO dao)
	{
		this.dao=dao;
	}


	@Override
	public int addNewProduct(Product toBeAdded) {
		
		if(toBeAdded.getPrice() * toBeAdded.getQoh() >=10000) {
			
			Product saved=dao.save(toBeAdded);
			return saved.getId();
		}
	
		else
		{
			throw new IllegalArgumentException("The value is less than 10000");
		}
	}

	@Override
	public void removeExisting(int id) {
		
		Product existing=dao.findById(id);
		if(existing.getPrice() * existing.getQoh()<10000) {
			dao.deleteById(id);
		}
		else
		{
		throw new IllegalStateException("can't delete");	
		}

	}
		
		 
	

	@Override
	public List<Product> findAll() {
		return dao.findAll();
		
	}

	@Override
	public Product findById(int id) {
		
		return dao.findById(id);
	}
	
	

}
