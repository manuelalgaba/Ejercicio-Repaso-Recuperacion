public abstract class Usuario {
    private String nif;
    private String nombre;
    private String telefono;
    private String email;
    
    public Usuario(String nif, String nombre, String telefono, String email) {
        this.nif = nif;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario [nif=" + nif + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + "]";
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
