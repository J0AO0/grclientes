package com.grclientes.domain.dto;

public class ProdutoDTO {
    private Integer id;
    private String nome;
    private Boolean status;
    private String sku;

    public ProdutoDTO() {

    }

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public ProdutoDTO(Integer id, String nome, Boolean status, String sku) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.sku = sku;
    }
}
