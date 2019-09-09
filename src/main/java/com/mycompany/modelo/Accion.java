/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

import java.io.Serializable;

/**
 * Declaracion de la Clase Accion
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 08-09-2019 1.0
 */

public class Accion implements Serializable{
    //Declaracion de los atributos privados de la clase
    private String titulo;
    private String accion;
    //Constructor de los atributos de la clase
    public Accion(String titulo, String accion) {
        this.titulo = titulo;
        this.accion = accion;
    }
    //Metodo que obtiene el valor del atributo Titulo
    public String getTitulo() {
        return titulo;
    }
    //Metodo que asigna el valor del atributo titulo al parametro titulo
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    //Metodo que obtiene el valor del atributo Accion
    public String getAccion() {
        return accion;
    }
    //Metodo que asigna el valor del atributo accion al parametro accion
    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    
}
