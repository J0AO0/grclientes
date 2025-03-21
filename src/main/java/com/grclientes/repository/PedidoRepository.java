package com.grclientes.repository;


import com.grclientes.domain.Pedido;
import com.grclientes.repository.query.PedidoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer>, PedidoRepositoryQuery {
    @Query(value = "SELECT * FROM pedido", nativeQuery = true)
    List<Pedido> findAllCat();

    @Query(value = "SELECT * FROM pedido where id = ?", nativeQuery = true)
    Pedido findPorId(Integer id);
}
