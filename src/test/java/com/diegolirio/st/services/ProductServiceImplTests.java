package com.diegolirio.st.services;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.diegolirio.st.domain.orm.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTests {

	@Autowired @Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Test
	public void testFindByCode() {
		Product product = productService.findByCode("123456");
		assertNull("product Must Be null", product);
	}
	
	
}
