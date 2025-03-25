package com.grclientes.domain.dto;

import com.grclientes.domain.Arquiteto;

import javax.persistence.ManyToOne;

public class VendedorNewDTO {
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

    public VendedorNewDTO(Integer id, String nome, Arquiteto arquiteto) {
        this.id = id;
        this.nome = nome;
        this.arquiteto = arquiteto;
    }
}
