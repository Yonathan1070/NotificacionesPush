/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.modelo.Accion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Declaracion de la Clase AdministradorController
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 08-09-2019 1.0
 */
@ManagedBean
@ApplicationScoped
public class AdministradorController implements Serializable{

    /**
     * Creacion nueva instancia de AdministradorController
     */
    //Declaracion del atributo privado tipo lista de la clase
    private List<Accion> listaAcciones;
    // metodo que convierte nuestra lista en un ArrayList
    public AdministradorController() {
       listaAcciones = new ArrayList();
    }
    //getter y setter de la lista listaAcciones
    public List<Accion> getListaAcciones() {
        return listaAcciones;
    }

    public void setListaAcciones(List<Accion> listaAcciones) {
        this.listaAcciones = listaAcciones;
    }
}
