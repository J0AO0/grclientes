package com.grclientes.domain.dto.flat;

import com.grclientes.domain.*;

public class PedidoFlat {
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

    public PedidoFlat(Integer id, Integer nf, Produto produto, Cliente cliente, Arquiteto arquiteto, Vendedor vendedor) {
        this.id = id;
        this.nf = nf;
        this.produto = produto;
        this.cliente = cliente;
        this.arquiteto = arquiteto;
        this.vendedor = vendedor;
    }

    public PedidoFlat(Pedido pedido) {
        this.id = pedido.getId();
        this.nf = pedido.getNf();
        this.produto = pedido.getProduto();
        this.cliente = pedido.getCliente();
        this.arquiteto = pedido.getArquiteto();
        this.vendedor = pedido.getVendedor();
    }
}
