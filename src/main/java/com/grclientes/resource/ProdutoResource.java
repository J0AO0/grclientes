package com.grclientes.resource;


import com.grclientes.domain.Produto;
import com.grclientes.domain.dto.ProdutoDTO;
import com.grclientes.domain.dto.ProdutoNewDTO;
import com.grclientes.domain.flat.ProdutoFlat;
import com.grclientes.repository.ProdutoRepository;
import com.grclientes.repository.filter.ProdutoFilter;
import com.grclientes.security.resource.CheckSecurity;
import com.grclientes.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProdutoRepository produtoRepo;

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<?> lista() {
//
//        List<ProdutoFlat> lista =  produtoService.findAllSql();
//
//        return ResponseEntity.ok(lista);
//    }


    @CheckSecurity.Produto.PodeConsultar
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Produto obj = produtoService.buscarOuFalhar(id);
        return ResponseEntity.ok(obj);
    }

    @CheckSecurity.Produto.PodeConsultar
    @RequestMapping( method = RequestMethod.GET)
    public Page<ProdutoFlat> findAllPag(ProdutoFilter produtoFilter, Pageable pageable) {
        Page<Produto> produtos = produtoRepo.filtrar(produtoFilter, pageable);
        Page<ProdutoFlat> produtosFlat = produtoService.mudarProdutoParaFlat(produtos);
        return produtosFlat;
    }

    @CheckSecurity.Produto.PodeConsultar
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<Produto>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                    @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                    @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                                    @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Produto> list = produtoService.findPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }

    @CheckSecurity.Produto.PodeCadastrar
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Produto> criarProduto(@Valid @RequestBody ProdutoNewDTO objNewDTO) {
        Produto novoObj = modelMapper.map(objNewDTO, Produto.class);
        Produto objNovo = produtoService.insert(objNewDTO);
        
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(objNovo.getId()).toUri();

        return ResponseEntity.created(uri).body(novoObj);
    }

    @CheckSecurity.Produto.PodeAtualizar
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Produto> update(@Valid @RequestBody ProdutoDTO obj, @PathVariable Integer id) {
        obj.setId(id);

        Produto novoObj = new Produto(obj);
        Produto obj1 = produtoService.atualiza(novoObj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(obj1.getId()).toUri();
        return ResponseEntity.created(uri).body(obj1);

    }

    @CheckSecurity.Produto.PodeAlterarStatus
    @RequestMapping(value="/{id}/status",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@RequestBody Boolean obj,@PathVariable int id)	{
        produtoService.status(obj,id);
    }

    @CheckSecurity.Produto.PodeExcluir
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
