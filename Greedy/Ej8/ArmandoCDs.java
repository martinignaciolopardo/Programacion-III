package Greedy.Ej8;

import java.util.ArrayList;

/**
 * Armando CDs. Dado un conjunto de archivos de canciones, donde cada uno tiene la información
 * de nombre, género, duración del tema, y tamaño en kilobytes, se desea grabar un disco CD (que
 * tiene una capacidad máxima de M kilobytes) de modo tal de:
 * ● Variante A: Maximizar la capacidad ocupada del disco CD.
 * ● Variante B: Maximizar la cantidad de canciones que se pueden grabar en el CD.
 * Para ambas variantes se quiere, además, que el CD no contenga más de 3 canciones de un
 * mismo género.
 */
public class ArmandoCDs {

    private ArrayList<Cancion> conjuntoCanciones;
    private ArrayList<Cancion> cd;

    private Double capacidad;

    public ArmandoCDs(ArrayList<Cancion> conjuntoCanciones, Double capacidad) {
        this.conjuntoCanciones = conjuntoCanciones;
        this.capacidad = capacidad;
        this.cd = new ArrayList<>();
    }

    public void maximizarEspacio(){
        while(!conjuntoCanciones.isEmpty()){
            Cancion c = cancionEficiente();
            if (c != null){
                if (this.getSuma() + c.getDuracion() <= this.capacidad){
                    cd.add(c);
                }
                else{
                    break;
                }
            }
            else {
                System.out.println("no quedan canciones.");
                break;
            }
        }
        System.out.println("Maximizar espacio: ");
        for (Cancion cancion:cd) {
            System.out.println(cancion.getNombre() + " / " + cancion.getDuracion() + "Min / " + cancion.getKbs() + "KB");
        }
    }

    public void maximizarCantidad(){
        while(!conjuntoCanciones.isEmpty()) {
            Cancion c = cancionMenorTamanio();
            if (c != null){
                if (this.getSuma() + c.getDuracion() <= this.capacidad){
                    cd.add(c);
                }
                else{
                    break;
                }
            }
            else {
                System.out.println("no quedan canciones.");
                break;
            }
        }
        System.out.println("\nMaximizar cantidad canciones: ");
        for (Cancion cancion:cd) {
            System.out.println(cancion.getNombre() + " / " + cancion.getDuracion() + "Min / " + cancion.getKbs() + "KB");
        }
    }

    private Cancion cancionEficiente(){
        Double masEficiente = 0.0;
        Cancion cancion = null;
        for (Cancion c: conjuntoCanciones) {
            Double eficienciaActual = c.getDuracion()/c.getKbs();
            if (eficienciaActual > masEficiente){
                masEficiente = eficienciaActual;
                cancion = c;
            }
        }
        if (cancion != null){
            conjuntoCanciones.remove(cancion);
        }
        return cancion;
    }

    private Double getSuma(){
        Double tamanioActual = 0.0;
        for (Cancion cancion:cd) {
            tamanioActual += cancion.getDuracion();
        }
        return tamanioActual;
    }

    private Cancion cancionMenorTamanio(){
        Double menorTamanio = Double.MAX_VALUE;
        Cancion cancion = null;
        for (Cancion c: conjuntoCanciones) {
            Double menorTamanioActual = c.getKbs();
            if (menorTamanioActual < menorTamanio){
                menorTamanio = menorTamanioActual;
                cancion = c;
            }
        }
        if (cancion != null){
            conjuntoCanciones.remove(cancion);
        }
        return cancion;
    }
}
