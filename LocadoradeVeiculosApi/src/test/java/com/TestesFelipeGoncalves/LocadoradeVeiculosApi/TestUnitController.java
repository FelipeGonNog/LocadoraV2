package com.TestesFelipeGoncalves.LocadoradeVeiculosApi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import springBootTest.Controller.TestController;

public class TestUnitController {
	
@Test
	public void TestUnit() {
		TestController controller = new TestController();
		String resultado = controller.saudacao("FELIPE");
		assertEquals("Bem vindo, FELIPE", resultado);
	}
	 
}
