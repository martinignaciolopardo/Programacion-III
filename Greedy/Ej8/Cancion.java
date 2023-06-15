package Greedy.Ej8;

public class Cancion {

    private String nombre;
    private String genero;
    private Double duracion;
    private Double kbs;

    public Cancion(String nombre, String genero, Double duracion, Double kbs) {
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.kbs = kbs;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public Double getKbs() {
        return kbs;
    }

    public void setKbs(Double kbs) {
        this.kbs = kbs;
    }
}
