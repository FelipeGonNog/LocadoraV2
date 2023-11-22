package com.TestesFelipeGoncalves.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
public Cliente cadastrar(Cliente cliente) {
	validarCamposObrigatorios(cliente);
    validarRegistroExistente(cliente.getId());
	return clienteRepository.save(cliente);
}
public Optional<Cliente>buscarPorId(Long id){
	return clienteRepository.findById(id);
}

public Cliente editar(Long id, Cliente cliente) {
	validarRegistroExistente(id);
    validarCamposObrigatorios(cliente);
    Optional<Cliente> clienteExistenteOptional = clienteRepository.findById(id);
    if (clienteExistenteOptional.isPresent()) {
        Cliente clienteExistente = clienteExistenteOptional.get();
        return clienteRepository.save(clienteExistente);
    } else {
        throw new NoSuchElementException("Cliente não encontrado com o ID: " + id);
    }
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
private void validarRegistroExistente(Long id) {
    if (id != null && clienteRepository.existsById(id)) {
        throw new IllegalStateException("Já existe um cliente cadastrado com o ID: " + id);
    }
}
private void validarCamposObrigatorios(Cliente cliente) {
    if (cliente.getNome() == null || cliente.getCpf() == null) {
        throw new IllegalArgumentException("Os campos 'nome' e 'cpf' são obrigatórios.");
    }

}

	
}
//()