package com.grclientes.domain.flat;

import com.grclientes.domain.Arquiteto;
import com.grclientes.domain.Vendedor;

public class VendedorFlat {
    private Integer id;
    private String nome;
    private Arquiteto arquiteto;

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

    public Arquiteto getArquiteto() {
        return arquiteto;
    }

    public void setArquiteto(Arquiteto arquiteto) {
        this.arquiteto = arquiteto;
    }

    public VendedorFlat(Integer id, String nome, Arquiteto arquiteto) {
        this.id = id;
        this.nome = nome;
        this.arquiteto = arquiteto;
    }

    public VendedorFlat(Vendedor vendedor) {
        this.id = vendedor.getId();
        this.nome = vendedor.getNome();
        this.arquiteto = vendedor.getArquiteto();
    }
}
