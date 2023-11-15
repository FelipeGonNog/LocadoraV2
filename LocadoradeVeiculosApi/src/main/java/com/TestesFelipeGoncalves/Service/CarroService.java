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

    public List<Carro> listar(){
    	return carroRepository.findAll();
    }

    public Carro salvar(Carro carro) {
    	return carroRepository.save(carro);
    }
   public Carro buscarPorId(Long id) {
	   Optional<Carro> carroOptional = carroRepository.findById(id);
	   return carroOptional.orElseThrow(() -> new NoSuchElementException("Carro nao encontrado com o ID:"+ id));      
   }
    
    public Carro editar(Carro carro) {
    	return carroRepository.save(carro);	
    }
    
   public void excluir(Long id) {
	   carroRepository.deleteById(id);
	   
   } 
    

}





//()