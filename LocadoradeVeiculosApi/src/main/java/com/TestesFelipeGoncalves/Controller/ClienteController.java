package com.TestesFelipeGoncalves.Controller;

import java.util.Optional;

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

import com.TestesFelipeGoncalves.Repository.ClienteRepository;
import com.TestesFelipeGoncalves.Service.ClienteService;
import com.TestesFelipeGoncalves.entity.Cliente;

import io.swagger.v3.oas.annotations.Operation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
@Autowired
private ClienteService clienteService;
@Autowired
private ClienteRepository clienteRepository;

@PostMapping
@Operation (summary = "Cadastra um cliente",description="Cadastra um cliente e salva o mesmo no banco de dados.")
public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
    logger.info("Recebendo solicitação para cadastrar cliente: {}", cliente);
    Cliente clienteSalvo = clienteRepository.save(cliente);
    logger.info("Cliente cadastrado com sucesso: {}", clienteSalvo);
    return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
}

@GetMapping("/{id}")
@Operation (summary = "Busca um cliente por id",description = "Busca um cliente em expecifico pelo Id no banco de dados.")
public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
    logger.info("Recebendo solicitação para buscar cliente por ID: {}", id);
    Optional<Cliente> cliente = clienteRepository.findById(id);
    if (cliente.isPresent()) {
        logger.info("Cliente encontrado: {}", cliente.get());
        return ResponseEntity.ok(cliente.get());
    } else {
        logger.info("Cliente não encontrado para o ID: {}", id);
        return ResponseEntity.notFound().build();
    }
}

@PutMapping("/{id}")
@Operation (summary= "Edita um cliente por id",description = "Busca um cliente em especifico para edita-lo no banco de dados." )
public ResponseEntity<Cliente> editar(@PathVariable Long id, @RequestBody Cliente cliente) {
    Cliente clienteExistente = clienteService.editar(cliente);
    return ResponseEntity.ok(clienteExistente);
}
@DeleteMapping("/{id}")
@Operation (summary= "Exclui um cliente por id",description = "Busca um cliente pelo id especifico para exclui-lo do banco de dados.")
public ResponseEntity<Void> excluir(@PathVariable Long id) {
    clienteService.excluir(id);
    return ResponseEntity.noContent().build();
}

}
//()