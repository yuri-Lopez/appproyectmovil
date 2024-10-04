package com.befj.appproyectmovil.Models;

public class Clsadministrardatos {

    private String nombre;
    private String apellido;
    private String documento;

    public String getPlanillaSeguridadSocial() {
        return planillaSeguridadSocial;
    }

    public void setPlanillaSeguridadSocial(String planillaSeguridadSocial) {
        this.planillaSeguridadSocial = planillaSeguridadSocial;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String telefono;
    private String correoElectronico;
    private String planillaSeguridadSocial;



}