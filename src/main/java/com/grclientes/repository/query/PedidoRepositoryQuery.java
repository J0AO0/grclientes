package com.grclientes.repository.query;

import com.grclientes.domain.Pedido;
import com.grclientes.repository.filter.PedidoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PedidoRepositoryQuery {
    public Page<Pedido> filtrar(PedidoFilter pedidoFilter, Pageable pageable);
}
