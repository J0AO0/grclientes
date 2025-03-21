package com.grclientes.repository;

import com.grclientes.domain.Arquiteto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArquitetoRepository extends JpaRepository<Arquiteto,Integer> {
    @Query(value = "SELECT * FROM arquiteto", nativeQuery = true)
    List<Arquiteto> findAllCat();

    @Query(value = "SELECT * FROM arquiteto where id = ?", nativeQuery = true)
    Arquiteto findPorId(Integer id);

    Arquiteto findByNome(String nome);
}
