package com.grclientes.domain.dto;

public class ArquitetoDTO {
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

    public ArquitetoDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ArquitetoDTO() {
    }
}
