package com.diegolirio.st.apis.v1;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.diegolirio.st.domain.orm.Product;
import com.diegolirio.st.domain.orm.ProductType;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ProductApiRestControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void testFindByCode() throws Exception {
		Product product = this.findByCode("123456");
		assertNull(product);
	}
	
	@Test
	public void testFindAll() throws Exception {
		List<Product> findAll = this.findAll();
		assertNotNull(findAll);
	}
	
	@Test
	public void testSave() throws Exception {
		ProductType productType = ProductType.builder().id("1l").description("Unidade").build();
		Product product = Product.builder().code("541A").description("TV").valueUnit(2500.99).productType(productType).active(true).build();
		Product productSaved = save(product);
		assertNotNull(productSaved.getId());
	}
	
	private Product findByCode(String code) throws Exception {
		String json = mockMvc.perform(get(ProductApiRestController.URL+"/"+code)
											.accept(MediaType.APPLICATION_JSON_UTF8))
								       .andExpect(status().isOk())
								       .andReturn().getResponse().getContentAsString();
		if(StringUtils.isEmpty(json)) 
			return null;
		return this.objectMapper.readValue(json, Product.class);
	}	
	
	private List<Product> findAll() throws Exception {
		String jsonList = mockMvc.perform(get(ProductApiRestController.URL)
											.accept(MediaType.APPLICATION_JSON_UTF8))
								       .andExpect(status().isOk())
								       .andReturn().getResponse().getContentAsString();
		return Arrays.asList(this.objectMapper.readValue(jsonList, Product[].class));
	}		
	
	private Product save(Product product) throws Exception {
		String jsonProduct = objectMapper.writeValueAsString(product);
		String json = mockMvc.perform(post(ProductApiRestController.URL)
							.accept(MediaType.APPLICATION_JSON_UTF8)
							.contentType(MediaType.APPLICATION_JSON_UTF8)
							.content(jsonProduct ))
						.andExpect(status().isOk())
						.andReturn().getResponse().getContentAsString();
		return objectMapper.readValue(json, Product.class);
	}
}
