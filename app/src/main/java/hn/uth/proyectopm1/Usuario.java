package hn.uth.proyectopm1;

public class Usuario {
    private String email;
    private String descripcion;
    private String fotoUrl;
    private String celular;

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Usuario() {
    }

    public Usuario(String email, String descripcion, String fotoUrl,String celular) {
        this.email = email;
        this.descripcion = descripcion;
        this.fotoUrl = fotoUrl;
        this.celular=celular;
    }
}
