package com.diegolirio.st.apis.v1;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.diegolirio.st.domain.orm.ProductType;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ProductTypeApiRestControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void testSave() throws Exception {
		ProductType productType = ProductType.builder().description("Unidade").build();
		String json = objectMapper.writeValueAsString(productType);
		String jsonSaved = mockMvc.perform(post(ProductTypeApiRestController.URL)
												.accept(MediaType.APPLICATION_JSON_UTF8)
												.contentType(MediaType.APPLICATION_JSON_UTF8)
												.content(json ))
											.andExpect(status().isOk())
											.andReturn().getResponse().getContentAsString();
		ProductType productTypeSaved = objectMapper.readValue(jsonSaved, ProductType.class);
		assertNotNull(productTypeSaved);
	}
	
	@Test
	public void testFindAll() throws Exception {
		mockMvc.perform(get(ProductTypeApiRestController.URL)
							.accept(MediaType.APPLICATION_JSON_UTF8))
						.andExpect(status().isOk());
	}
	
	
}
