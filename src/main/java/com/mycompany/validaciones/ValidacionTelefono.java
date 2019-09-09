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
 * Declaracion de la Clase ValidacionTelefono 
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 08-09-2019 1.0
 */
//valor que se otorga a la clase para ser llamada como validacion en el campo telefono del formulario
@FacesValidator(value = "validacionTelefono")
public class ValidacionTelefono implements Validator {
    @Override
    //metodo de validacion del campo telefono que valida mediante los valores establecidos el tipo de dato y que no sea nulo
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
