package com.grclientes.repository.query;


import com.grclientes.domain.Produto;
import com.grclientes.repository.filter.ProdutoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoRepositoryQuery {
    public Page<Produto> filtrar(ProdutoFilter produtoFilter, Pageable pageable);
}
