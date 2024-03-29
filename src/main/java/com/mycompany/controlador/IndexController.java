/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.modelo.Accion;
import com.mycompany.modelo.Usuario;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringEscapeUtils;
import org.primefaces.event.RowEditEvent;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

/**
 * Declaracion de la clase IndexController 
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 * @version 08-09-2019 1.0
 */
@ManagedBean
@RequestScoped
public class IndexController implements Serializable {
    //Declaracion de los atributos privados de la clase
    @ManagedProperty("#{registro}")
    private Registro registro;
    @ManagedProperty("#{administradorController}")
    private AdministradorController administrador;

    private Integer documento;
    private String nombres;
    private String apellidos;
    private Long telefono;

    /**
     * Creacion nueva instancia de IndexController
     */
    //Constructor vacio de la clase
    public IndexController() {
    }
    //getter y setter de los atributos de la clase
    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public AdministradorController getAdministrador() {
        return administrador;
    }

    public void setAdministrador(AdministradorController administrador) {
        this.administrador = administrador;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    //obtencion de id de la sesion para saber que cliente hace la accion
    FacesContext fCtx = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
    String sessionId = session.getId();
    
    //metodo de agregar informacion 
    public void agregarUsuario() {

        registro.getListaUsuarios().add(new Usuario(documento, nombres, apellidos, telefono));
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Completado",
                "Usuario agregado"));
        administrador.getListaAcciones().add(new Accion("Nuevo Registro", "El cliente " + sessionId + " ha agregado a " + nombres + " " + apellidos));
        notificarPush("Nuevo Registro", "El cliente " + sessionId + " ha agregado a " + nombres + " " + apellidos);
    }
    //metodo de editar informacion
    public void editarUsuario(RowEditEvent event) {
        Usuario usuario = ((Usuario) event.getObject());
        FacesMessage msg = new FacesMessage("Usuario", usuario.getNombres() + " editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        administrador.getListaAcciones().add(new Accion("Registro Actualizado", "El cliente " + sessionId + " ha modificado los datos de " + usuario.getNombres() + " " + usuario.getApellidos()));
        notificarPush("Registro Actualizado", "El cliente " + sessionId + " ha modificado los datos de " + usuario.getNombres() + " " + usuario.getApellidos());
    }
    //metodo de cancelacion de operacion por parte del usuario
    public void cancelar(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cancelado", "Operación cancelada por el usuario."));
    }
    //metodo de eliminacion de informacion
    public void eliminarUsuario(Usuario usuarioSeleccionado) {
        FacesMessage msg = new FacesMessage("Usuario", usuarioSeleccionado.getNombres() + " eliminado");
        administrador.getListaAcciones().add(new Accion("Registro Eliminado", "El cliente " + sessionId + " ha eliminado el usuario " + usuarioSeleccionado.getNombres() + " " + usuarioSeleccionado.getApellidos()));
        notificarPush("Registro Eliminado", "El cliente " + sessionId + " ha eliminado el usuario " + usuarioSeleccionado.getNombres() + " " + usuarioSeleccionado.getApellidos());
        registro.getListaUsuarios().remove(usuarioSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    //metodo que realiza la notificacion y la recibe el script que esta en la masterpage para ser mostrada en el socket que esta en el administrador
    public void notificarPush(String titulo, String detalle) {
        String canal = "/notificacion";

        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish(canal, new FacesMessage(StringEscapeUtils.escapeHtml3(titulo), StringEscapeUtils.escapeHtml3(detalle)));
    }
}
