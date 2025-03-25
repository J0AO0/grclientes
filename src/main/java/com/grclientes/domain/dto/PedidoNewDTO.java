package com.grclientes.domain.dto;

import com.grclientes.domain.Cliente;
import com.grclientes.domain.Produto;

public class PedidoNewDTO {
    private Integer id;
    private Integer nf;
    private Produto produto;
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNf() {
        return nf;
    }

    public void setNf(Integer nf) {
        this.nf = nf;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PedidoNewDTO(Integer id, Integer nf, Produto produto, Cliente cliente) {
        this.id = id;
        this.nf = nf;
        this.produto = produto;
        this.cliente = cliente;
    }
}
