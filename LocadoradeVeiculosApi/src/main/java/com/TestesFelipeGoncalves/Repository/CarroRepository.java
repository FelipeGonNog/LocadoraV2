package com.TestesFelipeGoncalves.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TestesFelipeGoncalves.entity.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{
List<Carro> findByClienteId(Long clienteId);
}
