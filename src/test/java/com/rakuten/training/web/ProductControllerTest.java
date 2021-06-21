package com.rakuten.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.rakuten.training.domain.Product;
import com.rakuten.training.service.ProductService;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers= {ProductController.class})
public class ProductControllerTest {
	
	@MockBean
	ProductService mockService;
	
	@Autowired
	MockMvc mockmvc;
	
	@Test
	void testById() throws Exception {
		
		//AAA
		//Arrange
		int pid=5;
	
		Product dataReturnedByMock=new Product("tst",10000,1);
		dataReturnedByMock.setId(5);
		Mockito.when(mockService.findById(pid)).thenReturn(dataReturnedByMock);
		
		//Act and Assert
		mockmvc
		.perform(MockMvcRequestBuilders.get("/products/{id}",pid))
		.andExpect(MockMvcResultMatchers.status().is(200))
		.andExpect(MockMvcResultMatchers.jsonPath("$.id",CoreMatchers.is(5)));
		
	}

}
