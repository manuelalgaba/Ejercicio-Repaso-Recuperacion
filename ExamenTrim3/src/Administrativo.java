public class Administrativo extends Empleado{
    private String puesto;
    private Categoria categoria;
    
    public Administrativo(String dni, String nombre, String direccion, String telefono, String fechaContrato,
            String puesto, Categoria categoria) {
        super(dni, nombre, direccion, telefono, fechaContrato);
        this.puesto = puesto;
        this.categoria = categoria;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString() + "Administrativo [puesto=" + puesto + ", categoria=" + categoria + "]";
    }

    
    
}
