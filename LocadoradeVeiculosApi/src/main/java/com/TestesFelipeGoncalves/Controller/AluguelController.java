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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
@Autowired
private AluguelService aluguelService;
	
//todos os alugueis

@GetMapping
@Operation (summary = "Pega todos os alugueis", description = "Pega todos os alugueis já cadastrados!" )
public ResponseEntity<List<Aluguel>> listarTodosAlugueis(){
	List<Aluguel> alugueis = aluguelService.listarTodosAlugueis();
	return new ResponseEntity<>(alugueis,HttpStatus.OK);
}//especifico cliente


@GetMapping("/cliente/{clienteId}")
@Operation (summary = "Lista alugueis por cliente e seu ID", description = "Pega a lista de alugueis especifica do cliente.")
public ResponseEntity<List<Aluguel>> listarAlugueisPorCliente(@PathVariable Long clienteId){
	List<Aluguel> alugueisCliente = aluguelService.listarAlugueisPorCliente(clienteId);
	return new ResponseEntity<>(alugueisCliente, HttpStatus.OK);
}
@GetMapping("/cliente/{clienteId}/carros-alugados")
@Operation(summary = "Conta carros alugados por cliente", description = "Pega a quantia de carros alugados por um cliente especifico.")
public ResponseEntity<Integer> contarCarrosAlugadosPorCliente(@PathVariable Long clienteId) {
    List<Aluguel> alugueisCliente = aluguelService.listarAlugueisPorCliente(clienteId);
    int quantidadeCarrosAlugados = alugueisCliente.size();
    return new ResponseEntity<>(quantidadeCarrosAlugados, HttpStatus.OK);
}


@PostMapping
@Operation (summary = "Salva um novo aluguel", description = "Salva um aluguel de um cliente.")
public ResponseEntity<Aluguel> salvar(@RequestBody Aluguel aluguel) {
    Aluguel aluguelSalvo = aluguelService.salvar(aluguel);
    return new ResponseEntity<>(aluguelSalvo, HttpStatus.CREATED);
	
}
@PutMapping("/{id}") 
@Operation (summary = "Edita um aluguel existente", description = "Edita um aluguel existente com base no id.")
public ResponseEntity<Aluguel> editar(@PathVariable Long id, @RequestBody Aluguel aluguel) {
    Aluguel aluguelEditado = aluguelService.editar(id, aluguel);
    return new ResponseEntity<>(aluguelEditado, HttpStatus.OK);
}

@DeleteMapping("/{id}")
@Operation (summary = "Exclui um aluguel", description = "Exclui um aluguel com base no seu id.")
public ResponseEntity<Void> excluir(@PathVariable Long id) {
    aluguelService.excluir(id);
    return ResponseEntity.noContent().build();
}

}
//()