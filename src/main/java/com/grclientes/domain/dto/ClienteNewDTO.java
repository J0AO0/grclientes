package com.grclientes.domain.dto;

import com.grclientes.domain.Vendedor;

public class ClienteNewDTO {
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

    public ClienteNewDTO(Integer id, String nome, Vendedor vendedor) {
        this.id = id;
        this.nome = nome;
        this.vendedor = vendedor;
    }
}
