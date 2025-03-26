package com.grclientes.domain.dto;

import com.grclientes.domain.Arquiteto;
import com.grclientes.domain.Cliente;
import com.grclientes.domain.Produto;
import com.grclientes.domain.Vendedor;

import javax.persistence.ManyToOne;

public class PedidoDTO {
    private Integer id;
    private Integer nf;
    private Produto produto;
    private Cliente cliente;
    private Arquiteto arquiteto;
    private Vendedor vendedor;

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

    public Arquiteto getArquiteto() {
        return arquiteto;
    }

    public void setArquiteto(Arquiteto arquiteto) {
        this.arquiteto = arquiteto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public PedidoDTO(Integer id, Integer nf, Produto produto, Cliente cliente, Arquiteto arquiteto, Vendedor vendedor) {
        this.id = id;
        this.nf = nf;
        this.produto = produto;
        this.cliente = cliente;
        this.arquiteto = arquiteto;
        this.vendedor = vendedor;
    }
}
