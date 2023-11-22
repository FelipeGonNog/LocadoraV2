package com.TestesFelipeGoncalves.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestesFelipeGoncalves.Repository.CarroRepository;
import com.TestesFelipeGoncalves.entity.Carro;

@Service
public class CarroService {
@Autowired
    private CarroRepository carroRepository;

    public List<Carro> listarTodosCarros(){
    	return carroRepository.findAll();
    }
    
    public List<Carro>ListarCarrosPorCliente(Long clienteId){
    	return carroRepository.findByClienteId(clienteId);
    }

    public Carro salvar(Carro carro) {
    	validarCamposObrigatorios(carro);
        validarRegistroExistente(carro.getId());
    	return carroRepository.save(carro);
    }
   public Carro buscarPorId(Long id) {
	   Optional<Carro> carroOptional = carroRepository.findById(id);
	   return carroOptional.orElseThrow(() -> new NoSuchElementException("Carro nao encontrado com o ID:"+ id));      
   }
    
    public Carro editar(Carro carro) {
    	validarRegistroExistente(carro.getId());
        validarCamposObrigatorios(carro);
    	return carroRepository.save(carro);	
    }
    
   public void excluir(Long id) {
	   carroRepository.deleteById(id);
	   
   } 
   private void validarRegistroExistente(Long id) {
       if (id != null && carroRepository.existsById(id)) {
           throw new IllegalStateException("Já existe um carro cadastrado com o ID: " + id);
       }
    }
       private void validarCamposObrigatorios(Carro carro) {
           if (carro.getMarca() == null || carro.getValor() == null || carro.getValor() == null) {
               throw new IllegalArgumentException("Os campos 'nome', 'categoria' e 'valor' são obrigatórios.");
           }

}
}



//()