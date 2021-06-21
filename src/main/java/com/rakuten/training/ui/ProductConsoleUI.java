package com.rakuten.training.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductService;


@Component
public class ProductConsoleUI {
	ProductService service; // =new ProductServiceimpl();
	
	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}
	
	public void createProductwithUI() {
		try (Scanner o = new Scanner(System.in)) {
			System.out.println("enter name");
			String name=o.nextLine();
			System.out.println("enter price");
			float price=Float.parseFloat(o.nextLine());
			System.out.println("enter qoh");
			int qoh=Integer.parseInt(o.nextLine());
			
			Product p=new Product(name,price,qoh);
			int id= service.addNewProduct(p);
			System.out.println("created product with id"+id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
