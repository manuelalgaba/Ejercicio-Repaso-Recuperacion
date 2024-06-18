import java.util.List;

public class Programador extends Empleado{
    private String nivel;
    private List<String> tecnologias;

    public Programador(String dni, String nombre, String direccion, String telefono, String fechaContrato, String nivel,
            List<String> tecnologias) {
        super(dni, nombre, direccion, telefono, fechaContrato);
        this.nivel = nivel;
        this.tecnologias = tecnologias;
    }

    
    @Override
    public String toString() {
        return super.toString() + "Programador [nivel=" + nivel + ", tecnologias=" + tecnologias + "]";
    }


    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public List<String> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<String> tecnologias) {
        this.tecnologias = tecnologias;
    }
    
}
