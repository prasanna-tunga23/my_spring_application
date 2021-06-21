//package com.rakuten.training;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.rakuten.training.dal.ProductDAO;
//import com.rakuten.training.dal.ProductDAOInMemimpl;
//import com.rakuten.training.service.ProductService;
//import com.rakuten.training.service.ProductServiceimpl;
//import com.rakuten.training.ui.ProductConsoleUI;
//
//@Configuration
//public class ProductAppConfiguration {
//	
//	public ProductDAO daoobj() {
//		ProductDAOInMemimpl dao=new ProductDAOInMemimpl();
//		return dao;
//	}
//	@Bean
//	public ProductService serviceObj() {
//		ProductServiceimpl service=new ProductServiceimpl();
//		service.setDao(daoobj());
//		
//		return service;
//	}
//	@Bean
//	public ProductConsoleUI uiobj() {
//		ProductConsoleUI ui=new ProductConsoleUI();
//		ui.setService(serviceObj());
//		return ui;
//	}
//
//}
