package com.TestesFelipeGoncalves.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TestesFelipeGoncalves.entity.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long>{
    List<Aluguel> findByClienteId(Long clientId);
}
