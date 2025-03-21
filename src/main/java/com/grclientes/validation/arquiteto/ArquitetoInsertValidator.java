package com.grclientes.validation.arquiteto;

import com.grclientes.domain.Arquiteto;
import com.grclientes.domain.dto.ArquitetoNewDTO;
import com.grclientes.repository.ArquitetoRepository;
import com.grclientes.resource.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ArquitetoInsertValidator implements ConstraintValidator<ArquitetoInsert, ArquitetoNewDTO> {
    @Autowired
    private ArquitetoRepository repo;
    @Override
    public void initialize(ArquitetoInsert ann){

    }

    @Override
    public boolean isValid(ArquitetoNewDTO value, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        Arquiteto cat = repo.findByNome(value.getNome());
        if (cat != null) {
            list.add(new FieldMessage("nome", " Arquiteto já existente "));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
