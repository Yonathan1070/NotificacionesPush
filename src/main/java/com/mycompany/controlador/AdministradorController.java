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
 *
 * @author Yonathan
 */
@ManagedBean
@ApplicationScoped
public class AdministradorController implements Serializable{

    /**
     * Creates a new instance of AdministradorController
     */
    private List<Accion> listaAcciones;
    public AdministradorController() {
        System.out.println("Entra Constructor Admin");
        listaAcciones = new ArrayList();
    }

    public List<Accion> getListaAcciones() {
        return listaAcciones;
    }

    public void setListaAcciones(List<Accion> listaAcciones) {
        this.listaAcciones = listaAcciones;
    }
}
