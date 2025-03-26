package com.grclientes.domain.dto.flat;

import com.grclientes.domain.Cliente;
import com.grclientes.domain.Vendedor;

public class ClienteFlat {
    private Integer id;
    private String nome;
    private Vendedor vendedor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public ClienteFlat(Integer id, String nome, Vendedor vendedor) {
        this.id = id;
        this.nome = nome;
        this.vendedor = vendedor;
    }

    public ClienteFlat(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.vendedor = cliente.getVendedor();
    }
}
