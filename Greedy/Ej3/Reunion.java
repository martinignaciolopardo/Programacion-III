package Greedy.Ej3;

public class Reunion {

    private String nombre;
    private int tiempoInicio;
    private int tiempoFin;

    public Reunion(String nombre, int tiempoInicio, int tiempoFin) {
        this.nombre = nombre;
        this.tiempoInicio = tiempoInicio;
        this.tiempoFin = tiempoFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(int tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public int getTiempoFin() {
        return tiempoFin;
    }

    public void setTiempoFin(int tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

}
