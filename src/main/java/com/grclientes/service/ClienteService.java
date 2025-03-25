package com.grclientes.service;


import com.grclientes.domain.Cliente;
import com.grclientes.domain.dto.ClienteDTO;
import com.grclientes.domain.dto.ClienteNewDTO;
import com.grclientes.repository.ClienteRepository;
import com.grclientes.service.exception.EntidadeNaoEncontradaExcepition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Page<Cliente> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Cliente findPorId(Integer id) {
        Cliente cat = repo.findPorId(id);
        return cat;
    }
    
    @Transactional
    public Cliente insert(ClienteNewDTO obj){
    	obj.setId(null);
        Cliente resEst = new Cliente();
        resEst.setNome(obj.getNome());
        return repo.save(resEst);
    }

    public Cliente atualiza(ClienteDTO obj) {
        Cliente resEst =  repo.findPorId(obj.getId());
        BeanUtils.copyProperties(obj, resEst, "id");
        return repo.save(resEst);
    }

    public void delete (Integer id) {
    	try {
    		repo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaExcepition(String.format("Cliente Nao Encontrado", id));
		}
    }

    public List<Cliente> lista() {

        List<Cliente> buscarTodas = repo.findAll();
        return buscarTodas;
    }

    public Cliente buscarOuFalhar(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Cliente  não encontrada", id)));
    }

}
