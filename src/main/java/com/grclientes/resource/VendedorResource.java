package com.grclientes.resource;

import com.grclientes.domain.Vendedor;
import com.grclientes.domain.dto.VendedorDTO;
import com.grclientes.domain.dto.VendedorNewDTO;
import com.grclientes.security.resource.CheckSecurity;
import com.grclientes.service.VendedorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorResource {

    @Autowired
    private VendedorService pedidoService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> lista() {

        List<Vendedor> lista =  pedidoService.lista();

        return ResponseEntity.ok(lista);
    }

    @CheckSecurity.Vendedor.PodeConsultar
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        Vendedor obj = pedidoService.buscarOuFalhar(id);
        return ResponseEntity.ok(obj);
    }

    @CheckSecurity.Vendedor.PodeCadastrar
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Vendedor> criarVendedor(@RequestBody VendedorNewDTO objNewDTO) {
        Vendedor novoObj = modelMapper.map(objNewDTO, Vendedor.class);
        Vendedor objNovo = pedidoService.insert(objNewDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(objNovo.getId()).toUri();

        return ResponseEntity.created(uri).body(novoObj);
    }

    @CheckSecurity.Vendedor.PodeAtualizar
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Vendedor> update(@Valid @RequestBody VendedorDTO obj, @PathVariable Integer id) {
        obj.setId(id);
        Vendedor obj1 = pedidoService.atualiza(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(obj1.getId()).toUri();
        return ResponseEntity.created(uri).body(obj1);

    }

    @CheckSecurity.Vendedor.PodeExcluir
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
