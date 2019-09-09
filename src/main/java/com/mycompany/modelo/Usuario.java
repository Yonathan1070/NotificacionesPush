/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

import java.io.Serializable;

/**
 * Declaracion de la Clase Usuario
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 08-09-2019 1.0
 */
public class Usuario implements Serializable{
    //Declaracion de los atributos privados de la clase
    private Integer documento;
    private String nombres;
    private String apellidos;
    private Long telefono;
    //Constructor vacio de la clase
    public Usuario() {
    }
    //Constructor de los atributos de la clase
    public Usuario(Integer documento, String nombres, String apellidos, Long telefono) {
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }
    //Metodo que obtiene el valor del atributo Documento
    public Integer getDocumento() {
        return documento;
    }
    //Metodo que asigna el valor del atributo documento al parametro documento
    public void setDocumento(Integer documento) {
        this.documento = documento;
    }
    //Metodo que obtiene el valor del atributo Nombres
    public String getNombres() {
        return nombres;
    }
    //metodo que asigna el valor del atributo nombres al parametro nombres
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    //Metodo que obtiene el valor del atributo Apellidos
    public String getApellidos() {
        return apellidos;
    }
    //Metodo que asigna el valor del atributo apelidos al parametro apellidos
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    //Metodo que obtiene el valor del atributo Telefono
    public Long getTelefono() {
        return telefono;
    }
    //Metodo que asigna el valor del atributo telefono al parametro telefono
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    
    
}
