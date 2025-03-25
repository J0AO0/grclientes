package com.grclientes.resource;


import com.grclientes.domain.Cliente;
import com.grclientes.domain.dto.ClienteDTO;
import com.grclientes.domain.dto.ClienteNewDTO;
import com.grclientes.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService repo;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> lista() {

        List<Cliente> lista =  repo.lista();

        return ResponseEntity.ok(lista);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Cliente obj = repo.buscarOuFalhar(id);
        return ResponseEntity.ok(obj);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Cliente> criarCliente(@Valid @RequestBody ClienteNewDTO objNewDTO) {
        Cliente novoObj = modelMapper.map(objNewDTO, Cliente.class);
        Cliente objNovo = repo.insert(objNewDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(objNovo.getId()).toUri();

        return ResponseEntity.created(uri).body(novoObj);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cliente> update(@Valid @RequestBody ClienteDTO obj, @PathVariable Integer id) {
        obj.setId(id);
        Cliente obj1 = repo.atualiza(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(obj1.getId()).toUri();
        return ResponseEntity.created(uri).body(obj1);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        repo.delete(id);
        return ResponseEntity.noContent().build();
    }
}
