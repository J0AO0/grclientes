package com.grclientes.service;


import com.grclientes.domain.*;
import com.grclientes.security.MEISecurity;
import com.grclientes.service.util.Tenantuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class LogSistemaService {
    @Autowired
	private MEISecurity meiSecurity;
    
    @Autowired
    private Tenantuser tenantUsuario;

	public LogSistema insert(Arquiteto obj, String acao) {
        String usuarioLogado = meiSecurity.getUsuario();
		Arquiteto cat = new Arquiteto();
        
        cat.setTenant(tenantUsuario.buscarOuFalhar());
	    String comando = (acao + "  " + obj.toString());
		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj, cat.getTenant());
		return log;		
	}
	public LogSistema insert(Cliente obj, String acao) {
        String usuarioLogado = meiSecurity.getUsuario();
	    String comando = (acao + "  " + obj.toString());
		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
		return log;		
	}

	public LogSistema insert(Pedido obj, String acao) {
        String usuarioLogado = meiSecurity.getUsuario();
	    String comando = (acao + "  " + obj.toString());
		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
		return log;		
	}
	
	public LogSistema insert(Produto obj, String acao) {
        String usuarioLogado = meiSecurity.getUsuario();
	    String comando = (acao + "  " + obj.toString());
	    Produto prod = new Produto();
	    
	    prod.setTenant(tenantUsuario.buscarOuFalhar());
	    
		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
		return log;		
	}

	public LogSistema insert(Usuario obj, String string) {
        String usuarioLogado = meiSecurity.getUsuario();
        
	    String comando = (string + "  " + obj.toString());
		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
		return log;	
	}
	public LogSistema insert(Empresa obj, String acao) {
		String usuarioLogado = meiSecurity.getUsuario();
	    String comando = (acao + obj.toString());
		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
		return log;
	}

	public LogSistema insert(Vendedor obj, String acao) {
		String usuarioLogado = meiSecurity.getUsuario();
		Vendedor formaPagamento = new Vendedor();
		formaPagamento.setTenant(tenantUsuario.buscarOuFalhar());

	    String comando = (acao + obj.toString());
		LogSistema log = new LogSistema(null,usuarioLogado,comando,OffsetDateTime.now(),obj);
		return log;
	}



}
