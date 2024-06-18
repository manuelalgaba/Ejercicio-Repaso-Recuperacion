public class Pista {
    private int idPista;
    private String tipoPista;
    private String descripcion;
    private String equipamiento;
    private int tamano;

    public Pista(int idPista, String tipoPista, String descripcion, String equipamiento, int tamano) {
        this.idPista = idPista;
        this.tipoPista = tipoPista;
        this.descripcion = descripcion;
        this.equipamiento = equipamiento;
        this.tamano = tamano;
    }

    public int getIdPista() {
        return idPista;
    }

    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }

    public String getTipoPista() {
        return tipoPista;
    }

    public void setTipoPista(String tipoPista) {
        this.tipoPista = tipoPista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "Pista [idPista=" + idPista + ", tipoPista=" + tipoPista + ", descripcion=" + descripcion
                + ", equipamiento=" + equipamiento + ", tamano=" + tamano + "]";
    }

    
}
