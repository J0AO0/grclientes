package com.grclientes.service;

import com.grclientes.domain.Vendedor;
import com.grclientes.domain.LogSistema;
import com.grclientes.domain.dto.VendedorDTO;
import com.grclientes.domain.dto.VendedorNewDTO;
import com.grclientes.domain.flat.VendedorFlat;
import com.grclientes.repository.VendedorRepository;
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
public class VendedorService {

    @Autowired
    private VendedorRepository repo;

    @Autowired
    private Tenantuser tenantUsuario;

    @Autowired
    private LogSistemaRepository repolog;

    @Autowired
    private LogSistemaService log;

    public Page<Vendedor> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Vendedor findPorId(Integer id) {
        Vendedor cat = repo.findPorId(id);


        return cat;
    }

    public Page<Vendedor> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    @Transactional
    public Vendedor insert(VendedorNewDTO obj){
        obj.setId(null);
        Vendedor resEst = new Vendedor();
        resEst.setNome(obj.getNome());
        resEst.setTenant(tenantUsuario.buscarOuFalhar());
        repo.save(resEst);
        logVendedor(resEst, "insert");
        return resEst;
    }

    public Vendedor atualiza(@Valid VendedorDTO obj) {
        Vendedor resEst =  repo.findPorId(obj.getId());
        resEst.setTenant(tenantUsuario.buscarOuFalhar());

        BeanUtils.copyProperties(obj, resEst, "id");
        resEst.setTenant(tenantUsuario.buscarOuFalhar());
        logVendedor(resEst, "Update");
        return repo.save(resEst);
    }

    public void delete (Integer id) {
        try {
            repo.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaExcepition(String.format("Vendedor não encontrada", id));
        }
    }

    public List<Vendedor> lista() {

        List<Vendedor> buscarTodas = repo.findAllCat();
        return buscarTodas;
    }

    public Vendedor buscarOuFalhar(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Vendedor  não encontrada", id)));
    }

    public Page<VendedorFlat> mudarVendedorParaFlat(Page<Vendedor> pacs) {
        List<VendedorFlat> cFlats = new ArrayList<VendedorFlat>();
        for (Vendedor c : pacs.getContent()) {
            VendedorFlat cFlat = new VendedorFlat(c);
            cFlats.add(cFlat);

        }
        Page<VendedorFlat> page = new PageImpl<>(cFlats, pacs.getPageable(),
                pacs.getTotalElements());

        return page;
    }

    private void logVendedor(Vendedor obj, String string) {
        LogSistema logsistema = log.insert(obj, string);
        logsistema.setVendedor(obj);
        repolog.save(logsistema);

    }

}
