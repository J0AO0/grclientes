package com.grclientes.repository.filter;

import com.grclientes.domain.Arquiteto;
import com.grclientes.domain.Cliente;
import com.grclientes.domain.Produto;
import com.grclientes.domain.Vendedor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PedidoFilter {

    private Integer id;
    private Cliente cliente;
    private Integer nf;
    private Produto produto;
    private Arquiteto arquiteto;
    private Vendedor vendedor;
    private String emailusuario;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datagravacaode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datagravacaoate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEmailusuario() {
        return emailusuario;
    }

    public void setEmailusuario(String emailusuario) {
        this.emailusuario = emailusuario;
    }

    public Date getDatagravacaode() {
        return datagravacaode;
    }

    public void setDatagravacaode(Date datagravacaode) {
        this.datagravacaode = datagravacaode;
    }

    public Date getDatagravacaoate() {
        return datagravacaoate;
    }

    public void setDatagravacaoate(Date datagravacaoate) {
        this.datagravacaoate = datagravacaoate;
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

    public PedidoFilter(Integer id, Cliente cliente, Integer nf, Produto produto, Arquiteto arquiteto, Vendedor vendedor, String emailusuario, Date datagravacaode, Date datagravacaoate) {
        this.id = id;
        this.cliente = cliente;
        this.nf = nf;
        this.produto = produto;
        this.emailusuario = emailusuario;
        this.datagravacaode = datagravacaode;
        this.datagravacaoate = datagravacaoate;
        this.vendedor = vendedor;
        this.arquiteto = arquiteto;
    }

    public PedidoFilter() {
    }
}
