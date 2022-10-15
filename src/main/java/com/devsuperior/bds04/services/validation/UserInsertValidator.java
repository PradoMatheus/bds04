package com.devsuperior.bds04.services.validation;

import com.devsuperior.bds04.dto.UserInsertDto;
import com.devsuperior.bds04.repositories.UserRepository;
import com.devsuperior.bds04.resource.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDto> {

    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(UserInsertValid ann) {
    }

    @Override
    public boolean isValid(UserInsertDto dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        var user = repository.findByEmail(dto.getEmail());
        if (user != null)
            list.add(new FieldMessage("email", "E-mail already exist"));

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}