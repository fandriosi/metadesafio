package com.andriosi.fabio.metadesafio.controller;

import com.andriosi.fabio.metadesafio.util.Utilities;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<Cpf, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return new Utilities().isCpf(value);
    }
}
