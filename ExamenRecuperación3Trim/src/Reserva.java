public class Reserva {
    private int idReserva;
    private int idPista;
    private String nifSocio;
    private String fechaReserva;
    private int turno;
    
    public Reserva(int idReserva, int idPista, String nifSocio, String fechaReserva, int turno) {
        this.idReserva = idReserva;
        this.idPista = idPista;
        this.nifSocio = nifSocio;
        this.fechaReserva = fechaReserva;
        this.turno = turno;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdPista() {
        return idPista;
    }

    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }

    public String getNifSocio() {
        return nifSocio;
    }

    public void setNifSocio(String nifSocio) {
        this.nifSocio = nifSocio;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Reserva [idReserva=" + idReserva + ", idPista=" + idPista + ", nifSocio=" + nifSocio + ", fechaReserva="
                + fechaReserva + ", turno=" + turno + "]";
    }

    
}
