import java.util.List;

public class Profesor extends Empleado{
    private int tiempoExperiencia;
    private List<String> cursos;
    
    public Profesor(String dni, String nombre, String direccion, String telefono, String fechaContrato,
            int tiempoExperiencia, List<String> cursos) {
        super(dni, nombre, direccion, telefono, fechaContrato);
        this.tiempoExperiencia = tiempoExperiencia;
        this.cursos = cursos;
    }

    public int getTiempoExperiencia() {
        return tiempoExperiencia;
    }

    public void setTiempoExperiencia(int tiempoExperiencia) {
        this.tiempoExperiencia = tiempoExperiencia;
    }

    public List<String> getCursos() {
        return cursos;
    }

    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return super.toString() + "Profesor [tiempoExperiencia=" + tiempoExperiencia + ", cursos=" + cursos + "]";
    }
    
}
