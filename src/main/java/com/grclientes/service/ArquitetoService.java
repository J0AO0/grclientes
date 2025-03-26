package com.grclientes.service;

import com.grclientes.domain.Arquiteto;
import com.grclientes.domain.LogSistema;
import com.grclientes.domain.dto.ArquitetoDTO;
import com.grclientes.domain.dto.ArquitetoNewDTO;
import com.grclientes.domain.dto.flat.ArquitetoFlat;
import com.grclientes.repository.ArquitetoRepository;
import com.grclientes.repository.LogSistemaRepository;
import com.grclientes.service.exception.EntidadeNaoEncontradaExcepition;
import com.grclientes.service.util.Tenantuser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArquitetoService {

    @Autowired
    private ArquitetoRepository repo;

    @Autowired
    private Tenantuser tenantUsuario;

    @Autowired
    private LogSistemaRepository repolog;

    @Autowired
    private LogSistemaService log;

    public Page<Arquiteto> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Arquiteto findPorId(Integer id) {
        Arquiteto cat = repo.findPorId(id);


        return cat;
    }

    public Page<Arquiteto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    @Transactional
    public Arquiteto insert(ArquitetoNewDTO obj){
        obj.setId(null);
        Arquiteto resEst = new Arquiteto();
        resEst.setNome(obj.getNome());
        resEst.setTenant(tenantUsuario.buscarOuFalhar());
        repo.save(resEst);
        logArquiteto(resEst, "insert");
        return resEst;
    }

    public Arquiteto atualiza(@Valid ArquitetoDTO obj) {
        Arquiteto resEst =  repo.findPorId(obj.getId());
        resEst.setTenant(tenantUsuario.buscarOuFalhar());

        BeanUtils.copyProperties(obj, resEst, "id");
        resEst.setTenant(tenantUsuario.buscarOuFalhar());
        logArquiteto(resEst, "Update");
        return repo.save(resEst);
    }

    public void delete (Integer id) {
        try {
            repo.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaExcepition(String.format("Arquiteto não encontrada", id));
        }
    }

    public List<Arquiteto> lista() {

        List<Arquiteto> buscarTodas = repo.findAllCat();
        return buscarTodas;
    }

    public Arquiteto buscarOuFalhar(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Arquiteto  não encontrada", id)));
    }

    public Page<ArquitetoFlat> mudarArquitetoParaFlat(Page<Arquiteto> pacs) {
        List<ArquitetoFlat> cFlats = new ArrayList<ArquitetoFlat>();
        for (Arquiteto c : pacs.getContent()) {
            ArquitetoFlat cFlat = new ArquitetoFlat(c);
            cFlats.add(cFlat);

        }
        Page<ArquitetoFlat> page = new PageImpl<>(cFlats, pacs.getPageable(),
                pacs.getTotalElements());

        return page;
    }

    private void logArquiteto(Arquiteto obj, String string) {
        LogSistema logsistema = log.insert(obj, string);
        logsistema.setArquiteto(obj);
        repolog.save(logsistema);

    }
}
