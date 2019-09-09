/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.socket;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.impl.JSONEncoder;

/**
 * Declaracion de la clase Notificacion
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 08-09-2019 1.0
 */
@PushEndpoint("/notificacion")
public class Notificacion implements Serializable{

    /**
     * Creacion nueva instancia de Notificacion
     */
    public Notificacion() {
    }
    //metodo que devuelve un mensaje
    @OnMessage(encoders = {JSONEncoder.class})
    public FacesMessage mensaje(FacesMessage mensajeNotificacion){
        return mensajeNotificacion;
    }
}
