package com.grclientes.repository.query;


import com.grclientes.domain.Empresa;
import com.grclientes.repository.filter.EmpresaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmpresaRepositoryQuery {
    public Page<Empresa> filtrar(EmpresaFilter empresaFilter, Pageable pageable);
}
