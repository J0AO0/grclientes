package com.grclientes.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ProdutoFilter {
    private Integer id;
    private String nome;
    private String status;
    private String sku;
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

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public ProdutoFilter(Integer id, String nome, String status, String sku, String emailusuario, Date datagravacaode, Date datagravacaoate) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.sku = sku;
        this.emailusuario = emailusuario;
        this.datagravacaode = datagravacaode;
        this.datagravacaoate = datagravacaoate;
    }

    public ProdutoFilter() {
    }
}
