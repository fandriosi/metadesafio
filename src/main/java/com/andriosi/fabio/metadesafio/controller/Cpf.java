package com.andriosi.fabio.metadesafio.controller;



import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = CpfValidator.class)
@Documented
public @interface Cpf {
    String message() default "Número do Cpf não é válido!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
