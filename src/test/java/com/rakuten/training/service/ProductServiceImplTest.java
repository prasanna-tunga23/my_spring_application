package com.rakuten.training.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rakuten.training.dal.ProductDAOInMemimpl;
import com.rakuten.training.domain.Product;

class ProductServiceImplTest {

	@Test
	
		void addNewProduct_Must_Return_NonZeroId_When_Value_LTEQ_10k() {
		//AAA-arrange-act-assert
		
		//arrange
		ProductServiceimpl objUnderTest=new ProductServiceimpl();
		Product paramToMethod=new Product("name",10000,1);
		//ProductDAOInMemimpl doubleOfRealDao=new ProductDAOInMemimpl();
		//objUnderTest.setDao(doubleOfRealDao);
		
		
		ProductdAOsTUB stub=new ProductdAOsTUB();
		objUnderTest.setDao(stub);
		//act
		
		int result=objUnderTest.addNewProduct(paramToMethod);
		
		//assert
		assertTrue(result>0);
	
	}
	@Test
	void addNewProduct_Must_Return_Zero_When_Value_LTEQ_10K()
	{
		//AAA
		//Arrange
		ProductServiceimpl objUnderTest =new ProductServiceimpl();
		Product paramToMethod =new Product("name2",1000,2);
		
		
		//Act
		try
		{	
		int result = objUnderTest.addNewProduct(paramToMethod);
		assertFalse(result>0);
		}catch(IllegalArgumentException e)
		{
		//Assert
		assertTrue(true);
		}
		
	}

}
