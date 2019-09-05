/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.validaciones;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Yonathan
 */
@FacesValidator(value = "validacionTelefono")
public class ValidacionTelefono implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String texto = String.valueOf(value);
        if (value == null) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Debe ingresar un Numero de telefono");
            throw new ValidatorException(msg);
        }
        Long numero = Long.parseLong(texto);
        if (numero < Long.parseLong("3000000000") || numero > Long.parseLong("3999999999")) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "El numero debe estar entre el rango de 3000000000 y 3999999999");
            throw new ValidatorException(msg);
        }
    }
}
