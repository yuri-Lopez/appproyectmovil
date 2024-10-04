package com.befj.appproyectmovil.Models;

public class DtoInfoLogin {

    private String token;
    private Usuario admininfo;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usuario getAdmininfo() {
        return admininfo;
    }

    public void setAdmininfo(Usuario admininfo) {
        this.admininfo = admininfo;
    }

    public static class Usuario{
        private String usuario;
        private String contraseña;

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getContraseña() {
            return contraseña;
        }

        public void setContraseña(String contraseña) {
            this.contraseña = contraseña;
        }
    }


}
