package com.TestesFelipeGoncalves.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestesFelipeGoncalves.Repository.ClienteRepository;
import com.TestesFelipeGoncalves.entity.Cliente;

@Service
public class ClienteService {
	
@Autowired
private ClienteRepository clienteRepository;

public List<Cliente> listar() {
	return clienteRepository.findAll();
		
}

public Cliente salvar(Cliente cliente) {
	return clienteRepository.save(cliente);		
	
}
public Cliente editar(Cliente cliente) {
	return clienteRepository.save(cliente);
	
}
public Long obterQuantidadeAlugueisPorCliente(Long clienteId) {
    Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
    if (clienteOptional.isPresent()) {
        Cliente cliente = clienteOptional.get();
        if (cliente.getAlugueis() != null) {
            return (long) cliente.getAlugueis().size();
        }
    }
    return 0L;
}
public void excluir(long id) {
	clienteRepository.deleteById(id);
}



	
}
//()