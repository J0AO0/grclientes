package com.grclientes.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
public class LogSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comando;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss:SSS")
    @Column(columnDefinition = "datetime")
    private OffsetDateTime datagravacao;
    private String emailUsuario;
    private Boolean status;
    @JsonIgnore
    @ManyToOne
    private Tenant tenant;

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public OffsetDateTime getDatagravacao() {
        return datagravacao;
    }

    public void setDatagravacao(OffsetDateTime datagravacao) {
        this.datagravacao = datagravacao;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public LogSistema(Integer id, String comando, OffsetDateTime datagravacao, String emailUsuario) {
        super();
        this.id = id;
        this.comando = comando;
        this.datagravacao = datagravacao;
        this.emailUsuario = emailUsuario;
        this.status = true;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "permissao_id", nullable = false)
    private Permissao permissao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "arquiteto_id", nullable = false)
    private Arquiteto arquiteto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Vendedor vendedor;

    public LogSistema() {

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao, Empresa empresa) {
        this.id = id;
        this.emailUsuario = usuarioLogado;
        this.comando = comando;
        this.datagravacao = datagravacao;
        this.empresa = empresa;
        this.status = true;
    }

    public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao, Produto produto) {
        this.id = id;
        this.emailUsuario = usuarioLogado;
        this.comando = comando;
        this.datagravacao = datagravacao;
        this.produto = produto;
        this.status = true;
    }

    public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao, Cliente cliente) {
        this.id = id;
        this.emailUsuario = usuarioLogado;
        this.comando = comando;
        this.datagravacao = datagravacao;
        this.cliente = cliente;
        this.status = true;
    }

    public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao, Usuario usu) {
        this.id = id;
        this.emailUsuario = usuarioLogado;
        this.comando = comando;
        this.datagravacao = datagravacao;
        this.usuario = usu;
        this.status = true;
    }

    public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao, Pedido pedido) {
        this.id = id;
        this.emailUsuario = usuarioLogado;
        this.comando = comando;
        this.datagravacao = datagravacao;
        this.pedido = pedido;
        this.status = true;
    }

    public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao,
                      Arquiteto arquiteto, Tenant tenant) {
        this.id = id;
        this.emailUsuario = usuarioLogado;
        this.comando = comando;
        this.datagravacao = datagravacao;
        this.arquiteto = arquiteto;
        this.tenant = tenant;
        this.status = true;
    }


    public LogSistema(Integer id, String usuarioLogado, String comando, OffsetDateTime datagravacao,
                      Vendedor vendedor) {
        this.id = id;
        this.emailUsuario = usuarioLogado;
        this.comando = comando;
        this.datagravacao = datagravacao;
        this.vendedor = vendedor;
        this.status = true;
    }

}
