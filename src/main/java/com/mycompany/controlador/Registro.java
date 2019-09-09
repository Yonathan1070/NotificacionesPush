/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Declaracion de la clase Registro que para nuestro caso es el Bean de apoyo 
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 08-09-2019 1.0
 */
@ManagedBean
@SessionScoped
public class Registro implements Serializable {
    //declaracion del atributo privado tipo lista de la clase
    private List<Usuario> listaUsuarios;

    /**
     * Creacion nueva instancia de Registro
     */
    //Metodo que convierte nuestra lista en un ArrayList
    public Registro() {
        listaUsuarios = new ArrayList();
    }
    // Getter y Setter de la lista listaUsuarios
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
