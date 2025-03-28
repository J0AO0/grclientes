package com.grclientes.resource;


import com.grclientes.domain.dto.CnpjDTOAPI;
import com.grclientes.domain.dto.CnpjFront;
import com.grclientes.resource.util.BR;
import com.grclientes.service.SevicosResquestAllAIP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value = "/cnpj")
@ApiIgnore
public class CnpjResource {



    @Autowired
    private SevicosResquestAllAIP service;

    @RequestMapping(value="/{cnpj}",method = RequestMethod.GET)
    public ResponseEntity<?> insertComCnpj(@PathVariable String cnpj){
        if (BR.isValidCNPJ(cnpj)) {
            CnpjDTOAPI cnpjDados =service.buscarcnpj(cnpj);
            CnpjFront cnpjfront = new CnpjFront(cnpjDados);
            if(cnpjfront.getFantasia()==null) {
                cnpjfront.setFantasia("");
            }
            if(cnpjfront.getTelefone()==null) {
                cnpjfront.setTelefone("");
            }
            if(cnpjfront.getTelefone()==null) {
                cnpjfront.setTelefone("");
            }
            if(cnpjfront.getCnaefiscal()==null) {
                cnpjfront.setCnaefiscal("");
            }
            if(cnpjfront.getCnaefiscaldescricao()==null) {
                cnpjfront.setCnaefiscaldescricao("");
            }


            return ResponseEntity.ok().body(cnpjfront);
        }

        return ResponseEntity.ok().body("inválido CNPJ");
    }

}