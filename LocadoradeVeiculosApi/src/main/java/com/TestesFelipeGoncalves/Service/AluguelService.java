package com.TestesFelipeGoncalves.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestesFelipeGoncalves.Controller.AluguelNaoEncontrado;
import com.TestesFelipeGoncalves.Repository.AluguelRepository;
import com.TestesFelipeGoncalves.Repository.CarroRepository;
import com.TestesFelipeGoncalves.entity.Aluguel;
import com.TestesFelipeGoncalves.entity.Carro;

@Service
public class AluguelService {
@Autowired
private AluguelRepository aluguelRepository;
@Autowired
private CarroRepository carroRepository;

public List <Aluguel> listarTodosAlugueis(){
	return aluguelRepository.findAll();
}

	

 public Aluguel salvar(Aluguel aluguel) {
	 return aluguelRepository.save(aluguel);
 }
public Aluguel editar(Aluguel aluguel) {
	return aluguelRepository.save(aluguel);
}

public void excluir(Long id) {
	aluguelRepository.deleteById(id);	
}
public List<Aluguel> listarAlugueisPorCliente(Long clienteId) {
    return aluguelRepository.findByClienteId(clienteId);
}

public Aluguel editar(Long id, Aluguel aluguel) {
    Optional<Aluguel> aluguelExistente = aluguelRepository.findById(id);
   
    
    if (aluguelExistente.isPresent()) {
        Aluguel aluguelParaEditar = aluguelExistente.get();
        return aluguelRepository.save(aluguelParaEditar);
    } else {
        throw new AluguelNaoEncontrado("Aluguel não encontrado para o ID: " + id);
    }
}

public List<Carro>listarCarrosAlugadosPorCliente(Long clienteId){
	return carroRepository.findByClienteId(clienteId);
}

}


//()
	