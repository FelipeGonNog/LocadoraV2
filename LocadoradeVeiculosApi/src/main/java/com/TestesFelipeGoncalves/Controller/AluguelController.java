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

import com.TestesFelipeGoncalves.Service.AluguelService;
import com.TestesFelipeGoncalves.entity.Aluguel;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
@Autowired
private AluguelService aluguelService;
	
//todos os alugueis

@GetMapping
public ResponseEntity<List<Aluguel>> listarTodosAlugueis(){
	List<Aluguel> alugueis = aluguelService.listarTodosAlugueis();
	return new ResponseEntity<>(alugueis,HttpStatus.OK);
}//especifico cliente

@GetMapping("/cliente/{clienteId}")
public ResponseEntity<List<Aluguel>> listarAlugueisPorCliente(@PathVariable Long clienteId){
	List<Aluguel> alugueisCliente = aluguelService.listarAlugueisPorCliente(clienteId);
	return new ResponseEntity<>(alugueisCliente, HttpStatus.OK);
}
@GetMapping("/cliente/{clienteId}/carros-alugados")
public ResponseEntity<Integer> contarCarrosAlugadosPorCliente(@PathVariable Long clienteId) {
    List<Aluguel> alugueisCliente = aluguelService.listarAlugueisPorCliente(clienteId);
    int quantidadeCarrosAlugados = alugueisCliente.size();
    return new ResponseEntity<>(quantidadeCarrosAlugados, HttpStatus.OK);
}



@PostMapping 
public ResponseEntity<Aluguel> salvar(@RequestBody Aluguel aluguel) {
    Aluguel aluguelSalvo = aluguelService.salvar(aluguel);
    return new ResponseEntity<>(aluguelSalvo, HttpStatus.CREATED);
	
}
@PutMapping("/{id}") 
public ResponseEntity<Aluguel> editar(@PathVariable Long id, @RequestBody Aluguel aluguel) {
    Aluguel aluguelEditado = aluguelService.editar(id, aluguel);
    return new ResponseEntity<>(aluguelEditado, HttpStatus.OK);
}

@DeleteMapping("/{id}")
public void excluir(@PathVariable Long id) {
	aluguelService.excluir(id);
}



}
//()