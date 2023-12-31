package com.TestesFelipeGoncalves.LocadoradeVeiculosApi;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;



@WebMvcTest
public class TestIntController {
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void testInt() throws Exception {
		RequestBuilder requisicao = get("/test");
		MvcResult resultado = mvc.perform(requisicao).andReturn();
		assertEquals("Bem vindo,Felipe", resultado.getResponse().getContentAsString());
	}
	
	@Test
	public void testIntComArgumento() throws Exception {
		mvc.perform(get("/test?nome=Reginaldo"))
		.andExpect(content().string("Bem-vindo, Reginaldo"));
	}

}	

