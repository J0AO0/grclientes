package com.grclientes.domain.dto.flat;

import com.grclientes.domain.Arquiteto;

public class ArquitetoFlat {
    private Integer id;
    private String nome;

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

    public ArquitetoFlat(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ArquitetoFlat() {
    }

    public ArquitetoFlat(Arquiteto arquiteto) {
        this.id = arquiteto.getId();
        this.nome = arquiteto.getNome();
    }


}
