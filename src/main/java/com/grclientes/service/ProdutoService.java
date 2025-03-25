package com.grclientes.service;


import com.grclientes.domain.LogSistema;
import com.grclientes.domain.Produto;
import com.grclientes.domain.dto.ProdutoDTO;
import com.grclientes.domain.dto.ProdutoNewDTO;
import com.grclientes.domain.flat.ProdutoFlat;
import com.grclientes.repository.LogSistemaRepository;
import com.grclientes.repository.ProdutoRepository;
import com.grclientes.service.exception.EntidadeEmUsoException;
import com.grclientes.service.exception.EntidadeNaoEncontradaExcepition;
import com.grclientes.service.util.Tenantuser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
	
    @Autowired
    private ProdutoRepository repo;
    
    @Autowired
	private Tenantuser tenantUsuario;

	@Autowired
	private LogSistemaRepository repolog;

	@Autowired
	private LogSistemaService log;

    public Page<Produto> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Produto findPorId(Integer id) {
        Produto cat = repo.findPorId(id);
        return cat;
    }
    
    @Transactional
    public Produto insert(ProdutoNewDTO obj){
    	obj.setId(null);
        Produto resEst = new Produto();
        resEst.setNome(obj.getNome());
        resEst.setSku(obj.getSku());
        resEst.setStatus(obj.getStatus());
        repo.save(resEst);
        logProduto(resEst, "Insert");
        
        return resEst;
    }

    public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Produto atualiza(Produto obj) {
        	Produto resEst =  repo.findPorId(obj.getId());
            resEst.setTenant(tenantUsuario.buscarOuFalhar());
            BeanUtils.copyProperties(obj, resEst, "id");
            resEst.setTenant(tenantUsuario.buscarOuFalhar());
            repo.save(resEst);
            logProduto(resEst, "Update");
            return resEst;
        }

    public void delete (Integer id) {
    	try {
			if(!repo.existsById(id)) {
				throw new EntidadeNaoEncontradaExcepition(String.format("Produto não encontrado", id));
			}
			repo.deleteById(id);
    		
		} catch (DataIntegrityViolationException e) {
		throw new EntidadeEmUsoException(String.format("Produto não pode ser deletado", id));
		}
    }

    public List<ProdutoFlat> findAllSql() {
		List<Produto> operadores = repo.findAllSql(tenantUsuario.buscarOuFalharInt());
		List<ProdutoFlat> operadorFlat = new ArrayList<>();
		for (Produto obj : operadores) {
			ProdutoFlat opeFlat = new ProdutoFlat(obj);
			operadorFlat.add(opeFlat);
		}
		return operadorFlat;
	}

    public Produto buscarOuFalhar(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaExcepition(String.format("Produto  não encontrado", id)));
    }

    @Transactional
    public void status(Boolean obj, int id) {
        Produto produto = buscarOuFalhar(id);
        produto.setStatus(obj);

    }

    public Page<ProdutoFlat> mudarProdutoParaFlat(Page<Produto> pacs) {
        List<ProdutoFlat> cFlats = new ArrayList<ProdutoFlat>();
        for (Produto p : pacs.getContent()) {
            ProdutoFlat cFlat = new ProdutoFlat(p);
            cFlats.add(cFlat);

        }
        Page<ProdutoFlat> page = new PageImpl<>(cFlats, pacs.getPageable(),
                pacs.getTotalElements());

        return page;
    }

    public ProdutoDTO getProdutoById(Integer id) {
        // Busca o produto no repositório
        Produto produto = repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaExcepition("Produto não encontrado"));
//        // Constrói o caminho completo da imagem
//        String imagemPath = "/assets/fotos_produto/" + produto.getQrCode();
        // Cria o ProdutoDTO e preenche os dados do produto
        ProdutoDTO produtoDto = new ProdutoDTO();
        produtoDto.setId(produto.getId());
        produtoDto.setNome(produto.getNome());
        produtoDto.setSku(produto.getSku());
        produtoDto.setStatus(produto.getStatus());
        return produtoDto;
    }
    
	private void logProduto(Produto obj, String string) {
		LogSistema logsistema = log.insert(obj, string);
		logsistema.setProduto(obj);
		repolog.save(logsistema);

	}
}
