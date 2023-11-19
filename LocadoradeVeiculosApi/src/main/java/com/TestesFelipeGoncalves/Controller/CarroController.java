package com.TestesFelipeGoncalves.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/carros")
public class CarroController {
     @Autowired
     private CarroService carroService;
    @Autowired
    private CarroRepository carroRepository;
    
     @GetMapping
     @Operation (summary = "Lista todos os carros cadastrados", description ="Lista todos os carros que forem encontrados.")
     public ResponseEntity<List<Carro>> getCarros(){
    	 List<Carro> carros = carroRepository.findAll();
     	return new ResponseEntity<>(carros,HttpStatus.OK);
     }
     
     @GetMapping("/cliente/{clienteId}")
     @Operation (summary = "Pega os carros por cliente",description = "Pega os carros por cliente pelo id do mesmo.")
     public ResponseEntity<List<Carro>> getCarrosPorCliente(@PathVariable Long clienteId) {
         List<Carro> carrosPorCliente = carroRepository.findByClienteId(clienteId);
         return new ResponseEntity<>(carrosPorCliente, HttpStatus.OK);
     }
      
   @PostMapping
   @Operation(summary ="Salva um novo carro",description ="Salva um carro e retorna ")
   public ResponseEntity<Carro> salvar(@RequestBody Carro carro) {
       Carro carroSalvo = carroService.salvar(carro);
       return new ResponseEntity<>(carroSalvo, HttpStatus.CREATED);
   }
   @PutMapping("/{id}")
   @Operation(summary ="Edita um carro existente", description = "Edita um carro existente com base no seu Id.")
   public ResponseEntity<Carro> editar(@PathVariable Long id, @RequestBody Carro carro) {
       Carro carroExistente = carroService.buscarPorId(id);
       if (carroExistente != null) {
           carroExistente.setMarca(carro.getMarca());
           carroExistente.setModelo(carro.getModelo());
           Carro carroEditado = carroService.editar(carroExistente);
           return new ResponseEntity<>(carroEditado, HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
  
   }
   @DeleteMapping("/{id}")
   @Operation(summary= "Exclui um carro",description ="Exclui um carro com base no seu id.")
   public ResponseEntity<Void> excluir(@PathVariable Long id) {
       carroService.excluir(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
	
	
}
//()