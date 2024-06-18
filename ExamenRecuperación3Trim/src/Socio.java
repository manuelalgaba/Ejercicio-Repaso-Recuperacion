import java.util.*;

public class Socio extends Usuario {
    private String fechaMatricula;
    private double cuota;
    private List<Invitado> invitados;

    public Socio(String nif, String nombre, String telefono, String email, String fechaMatricula, double cuota, List<Invitado> invitados) {
        super(nif, nombre, telefono, email);
        this.fechaMatricula = fechaMatricula;
        this.cuota = cuota;
        this.invitados = invitados;
    }

    public String getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(String fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public List<Invitado> getInvitados() {
        return invitados;
    }

    public void setInvitados(List<Invitado> invitados) {
        this.invitados = invitados;
    }

    @Override
    public String toString() {
        return super.toString() + "Socio [fechaMatricula=" + fechaMatricula + ", cuota=" + cuota + ", invitados="
                + invitados + "]";
    }

    public void addInvitado(Invitado invitado) { // Agrag un invitado a la lista de inviatdos
        if (invitados.size() < 5) {
            invitados.add(invitado);
        } else {
            System.out.println("Un socio no puede tener más de 5 invitados.");
        }
    }

}
