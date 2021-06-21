package com.rakuten.training.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductService;

public class WrongwaytoControllers {

	@Test
	void testGetById() {
		
		//AAA
		//Arrange
		ProductController objUnderTest=new ProductController();
		int pid=5;
		ProductService mockService=Mockito.mock(ProductService.class);
		Product dataReturnedByMock=new Product("tst",10000,1);
		dataReturnedByMock.setId(5);
		Mockito.when(mockService.findById(pid)).thenReturn(dataReturnedByMock);
		objUnderTest.service=mockService;
		
		//Act
		ResponseEntity<Product> response=objUnderTest.getById(pid);
		
		//Assert
		assertTrue(response.getStatusCode()==HttpStatus.OK);
	}

}
