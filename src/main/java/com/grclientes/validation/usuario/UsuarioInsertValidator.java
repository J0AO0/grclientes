package com.grclientes.validation.usuario;

import com.grclientes.domain.Usuario;
import com.grclientes.domain.dto.UsuarioNewDTO;
import com.grclientes.repository.UsuarioRepository;
import com.grclientes.resource.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UsuarioInsertValidator implements ConstraintValidator<UsuarioInsert, UsuarioNewDTO> {
    @Autowired
    private UsuarioRepository repo;

    @Override
    public void initialize(UsuarioInsert ann) {
    }

    @Override
    public boolean isValid(UsuarioNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        Usuario aux1 = repo.findPorEmail(objDto.getEmail());
        if(aux1 !=null) {
            list.add(new FieldMessage("email"," Email já existente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();

    }
}
