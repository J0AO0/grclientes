package com.grclientes.resource;


import com.grclientes.domain.Codigo;
import com.grclientes.domain.Usuario;
import com.grclientes.repository.UsuarioRepository;
import com.grclientes.security.MEISecurity;
import com.grclientes.service.SevicosResquestAllAIP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/d/")
public class SiteResource {

    @Autowired
    private SevicosResquestAllAIP serviceApi;

    @Autowired
    private UsuarioRepository repoUsu;
    @Autowired
    private MEISecurity token;
    @Autowired
    private UsuarioRepository repoUsuario;



    ///////////SMS//////////
    @RequestMapping(value = "/sms/{telefone}",method = RequestMethod.PUT)
    public void sms(@PathVariable String telefone) {
        Usuario usu = repoUsu.findPorTelefone(telefone);
        if(usu == null) {
            String resposta = serviceApi.enviarSms(telefone);
        }else {
            Codigo codigo = serviceApi.buscarOuFalhar2(0);
        }


    }
    @RequestMapping(value = "/validasms",method = RequestMethod.POST)
    public ResponseEntity<?> validasms(@RequestBody Codigo obj1) {
        Codigo resposta = serviceApi.validaSMSs(obj1);
        return ResponseEntity.ok().body(resposta);
    }






}
