package com.rakuten.training.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector.Executable;
import org.mockito.Mockito;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ProductDAOInMemimpl;
import com.rakuten.training.domain.Product;

class ProductServiceImplTestWithMocks {

	@Test
	
		void addNewProduct_Must_Return_NonZeroId_When_Value_GTEQ_10k() {
		//AAA-arrange-act-assert
		
		//arrange
		ProductServiceimpl objUnderTest=new ProductServiceimpl();
		Product paramToMethod=new Product("name",10000,1);
		Product saved=new Product();
		saved.setId(1);
		
		ProductDAO mockDAO=Mockito.mock(ProductDAO.class);
		Mockito.when(mockDAO.save(paramToMethod)).thenReturn(saved);
		objUnderTest.setDao(mockDAO);
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
		
		
		//Act and assert
	
		assertThrows(IllegalArgumentException.class,()->objUnderTest.addNewProduct(paramToMethod));
		
		
		
	}
	@Test
	void removeExisting_Must_Delete_Product_When_Value_LT_10K()
	{
		//AAA
		//Arrange
		ProductServiceimpl service =new ProductServiceimpl();
		int pid=5;
		
		
		
		
		ProductDAO mockDAO=Mockito.mock(ProductDAO.class);
		Product dataReturnedByMock = new Product("test",9999,1);
		Mockito.when(mockDAO.findById(pid)).thenReturn(dataReturnedByMock);
		service.setDao(mockDAO);
		
		//Act
		service.removeExisting(pid);
		
		//Assert
	
		Mockito.verify(mockDAO).deleteById(pid);
		
		
		
	}
	@Test
	void removeExistingt_Must_Return_Zero_When_Value_GTEQ_10K()
	{
		//AAA
		//Arrange
		ProductServiceimpl service =new ProductServiceimpl();
		int pid=5;
		
		ProductDAO mockDAO=Mockito.mock(ProductDAO.class);
		Product dataReturnedByMock = new Product("test",99999,1);
		Mockito.when(mockDAO.findById(pid)).thenReturn(dataReturnedByMock);
		service.setDao(mockDAO);
		
		//Act and assert
	
		assertThrows(IllegalStateException.class,()->service.removeExisting(pid));
		
		
		
	}

}
