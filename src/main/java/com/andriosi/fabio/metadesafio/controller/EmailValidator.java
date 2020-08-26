package com.andriosi.fabio.metadesafio.controller;

import com.andriosi.fabio.metadesafio.util.Utilities;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return new Utilities().isMail(value);
    }
}
