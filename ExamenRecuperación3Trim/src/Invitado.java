public class Invitado extends Usuario {
    private String relacion;

    public Invitado(String nif, String nombre, String telefono, String email, String relacion) {
        super(nif, nombre, telefono, email);
        this.relacion = relacion;
    }

    @Override
    public String toString() {
        return super.toString() + "Invitado [relacion=" + relacion + "]";
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

}
