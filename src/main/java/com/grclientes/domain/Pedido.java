package com.grclientes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grclientes.domain.dto.ClienteDTO;
import com.grclientes.domain.dto.ClienteNewDTO;
import com.grclientes.domain.dto.PedidoDTO;
import com.grclientes.domain.dto.PedidoNewDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer nf;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Arquiteto arquiteto;

    @ManyToOne Vendedor vendedor;

    @ManyToOne
    private Tenant tenant;

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

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
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

    public Pedido(Integer id, Integer nf, Produto produto, Cliente cliente, Arquiteto arquiteto, Vendedor vendedor, Tenant tenant) {
        this.id = id;
        this.nf = nf;
        this.produto = produto;
        this.cliente = cliente;
        this.arquiteto = arquiteto;
        this.vendedor = vendedor;
        this.tenant = tenant;
    }

    public Pedido() {
    }

    public Pedido(PedidoDTO obj){
        this.id = obj.getId();
        this.nf = obj.getNf();
        this.produto = obj.getProduto();
        this.cliente = obj.getCliente();
    }

    public Pedido(PedidoNewDTO obj){
        this.id = obj.getId();
        this.nf = obj.getNf();
        this.produto = obj.getProduto();
        this.cliente = obj.getCliente();
    }

    @JsonIgnore
    @OneToMany(mappedBy = "pedido")
    private List<LogSistema> logs = new ArrayList<LogSistema>();

    public void addLogs(LogSistema log) {
        logs.add(log);
    }

    public LogSistema getLogs() {
        Integer codigo = 0;
        Integer indice = -1;
        LogSistema ultimo = new LogSistema();
        for (int i = 0; i < logs.size(); i++) {
            if (codigo < logs.get(i).getId()) {
                codigo = logs.get(i).getId();
                indice = i;
            }
        }
        if (indice==-1) {
            return ultimo;
        }else {
            return ultimo = logs.get(indice);
        }

    }

    public void setLogs(List<LogSistema> logs) {
        this.logs = logs;
    }
}
