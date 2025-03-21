package com.grclientes.repository;


import com.grclientes.domain.LogSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogSistemaRepository extends JpaRepository<LogSistema, Integer> {
	
}