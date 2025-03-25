package com.grclientes.repository;

import com.grclientes.domain.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor,Integer> {
    @Query(value = "SELECT * FROM vendedor", nativeQuery = true)
    List<Vendedor> findAllCat();

    @Query(value = "SELECT * FROM vendedor where id = ?", nativeQuery = true)
    Vendedor findPorId(Integer id);

    Vendedor findByNome(String nome);
}
