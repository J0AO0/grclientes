package com.grclientes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grclientes.domain.dto.ArquitetoDTO;
import com.grclientes.domain.dto.ArquitetoNewDTO;
import com.grclientes.domain.dto.VendedorDTO;
import com.grclientes.domain.dto.VendedorNewDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    private Arquiteto arquiteto;

    @ManyToOne
    private Tenant tenant;

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

    public Arquiteto getArquiteto() {
        return arquiteto;
    }

    public void setArquiteto(Arquiteto arquiteto) {
        this.arquiteto = arquiteto;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Vendedor(Integer id, String nome, Arquiteto arquiteto, Tenant tenant) {
        this.id = id;
        this.nome = nome;
        this.arquiteto = arquiteto;
        this.tenant = tenant;
    }

    public Vendedor() {
    }

    public Vendedor(VendedorDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.arquiteto = obj.getArquiteto();
    }

    public Vendedor(VendedorNewDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.arquiteto = obj.getArquiteto();
    }

    @JsonIgnore
    @OneToMany(mappedBy = "vendedor")
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
