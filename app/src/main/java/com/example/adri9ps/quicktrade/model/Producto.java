package com.example.adri9ps.quicktrade.model;

/**
 * Created by adri9ps on 17/1/18.
 */

public class Producto {

    //Variables
    String usuario;
    String nombre;
    String descripcion;
    String categoria;
    String precio;
    String codigo_usuario_logueado;

    public Producto(String nombre, String descripcion, String categoria, String precio,    String codigo_usuario_logueado ) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.codigo_usuario_logueado = codigo_usuario_logueado;


    }

    public Producto (){

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCodigo_usuario_logueado() {
        return codigo_usuario_logueado;
    }

    public void setCodigo_usuario_logueado(String precio) {
        this.codigo_usuario_logueado = codigo_usuario_logueado;
    }


}
