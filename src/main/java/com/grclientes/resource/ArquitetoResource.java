package com.grclientes.resource;

import com.grclientes.domain.Arquiteto;
import com.grclientes.domain.dto.ArquitetoDTO;
import com.grclientes.domain.dto.ArquitetoNewDTO;
import com.grclientes.security.resource.CheckSecurity;
import com.grclientes.service.ArquitetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.modelmapper.ModelMapper;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/arquitetos")
public class ArquitetoResource {

    @Autowired
    private ArquitetoService pedidoService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> lista() {

        List<Arquiteto> lista =  pedidoService.lista();

        return ResponseEntity.ok(lista);
    }

    @CheckSecurity.Arquiteto.PodeConsultar
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Arquiteto obj = pedidoService.buscarOuFalhar(id);
        return ResponseEntity.ok(obj);
    }

    @CheckSecurity.Arquiteto.PodeCadastrar
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Arquiteto> criarArquiteto(@RequestBody ArquitetoNewDTO objNewDTO) {
        Arquiteto novoObj = modelMapper.map(objNewDTO, Arquiteto.class);
        Arquiteto objNovo = pedidoService.insert(objNewDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(objNovo.getId()).toUri();

        return ResponseEntity.created(uri).body(novoObj);
    }

    @CheckSecurity.Arquiteto.PodeAtualizar
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Arquiteto> update(@Valid @RequestBody ArquitetoDTO obj, @PathVariable Integer id) {
        obj.setId(id);
        Arquiteto obj1 = pedidoService.atualiza(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(obj1.getId()).toUri();
        return ResponseEntity.created(uri).body(obj1);

    }

    @CheckSecurity.Arquiteto.PodeExcluir
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
