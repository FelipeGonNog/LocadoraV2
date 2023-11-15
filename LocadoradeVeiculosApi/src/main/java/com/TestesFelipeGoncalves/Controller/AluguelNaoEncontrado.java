package com.TestesFelipeGoncalves.Controller;

public class AluguelNaoEncontrado extends RuntimeException {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public AluguelNaoEncontrado(String message) {
	   super(message);
   }
}
