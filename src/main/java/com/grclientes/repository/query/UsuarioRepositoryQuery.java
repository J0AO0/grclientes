package com.grclientes.repository.query;

import com.grclientes.domain.Usuario;
import com.grclientes.repository.filter.UsuarioFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioRepositoryQuery {
    public Page<Usuario> filtrar(UsuarioFilter usuarioFilter, Pageable pageable);
}
