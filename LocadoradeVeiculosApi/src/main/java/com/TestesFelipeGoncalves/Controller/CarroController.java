package com.TestesFelipeGoncalves.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TestesFelipeGoncalves.Repository.CarroRepository;
import com.TestesFelipeGoncalves.Service.CarroService;
import com.TestesFelipeGoncalves.entity.Carro;

@RestController
@RequestMapping("/carros")
public class CarroController {
     @Autowired
     private CarroService carroService;
    @Autowired
    private CarroRepository carroRepository;
    
     @GetMapping 
     public List<Carro> getCarros(){
     	return carroRepository.findAll();
     }
     
     @GetMapping("/cliente/{clienteId}")
     public List<Carro> getCarrosPorCliente(@PathVariable Long clienteId){
       return carroRepository.findByClienteId(clienteId); 	
     }
      
   @PostMapping
   public Carro salvar(@RequestBody Carro carro) {
	return carroService.salvar(carro);   
   }
   @PutMapping("/{id}")
   public Carro editar(@PathVariable Long id,@RequestBody Carro carro) {
	  Carro carroExistente =carroService.buscarPorId(id);
	        if (carroExistente !=null) {
	        	carroExistente.setMarca(carro.getMarca());
	        	carroExistente.setModelo(carro.getModelo());
	        	return carroService.editar(carroExistente);
	        } else {
	        	return null;
	        }
   }
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		carroService.excluir(id);
	
	}
	
	
}
//()