package com.grclientes.domain.flat;

import com.grclientes.domain.Arquiteto;
import com.grclientes.domain.Cliente;
import com.grclientes.domain.Pedido;
import com.grclientes.domain.Produto;

public class PedidoFlat {
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

    public PedidoFlat(Integer id, Integer nf, Produto produto, Cliente cliente) {
        this.id = id;
        this.nf = nf;
        this.produto = produto;
        this.cliente = cliente;
    }

    public PedidoFlat(Pedido pedido) {
        this.id = pedido.getId();
        this.nf = pedido.getNf();
        this.produto = pedido.getProduto();
        this.cliente = pedido.getCliente();
    }
}
