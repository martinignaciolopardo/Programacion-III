package Greedy.Ej3;

import java.util.ArrayList;

public class ActividadesCompatibles {

    ArrayList<Reunion> conjuntoReuniones;
    ArrayList<Reunion> solucion;

    public ActividadesCompatibles(ArrayList<Reunion> conjuntoReuniones) {
        this.conjuntoReuniones = conjuntoReuniones;
        this.solucion = new ArrayList<>();
    }

    public void greedy(){
        while(!conjuntoReuniones.isEmpty()){
            Reunion aux = mejorReunion();
            if (aux != null){
                this.solucion.add(aux);
                borrarReunionesNoDisponibles(aux);
            }
        }
        for (int i = 0; i < this.solucion.size(); i++) {
            System.out.println(this.solucion.get(i).getNombre());
        }
    }

    public Reunion mejorReunion(){
        Reunion aux = null;
        int indexMejorSeleccion = -1;
        int menorTiempo = 25;
        for (int i = 0; i < conjuntoReuniones.size(); i++) {
            int auxTiempo = conjuntoReuniones.get(i).getTiempoFin();
            if(auxTiempo < menorTiempo){
                indexMejorSeleccion = i;
                menorTiempo = auxTiempo;
                aux = conjuntoReuniones.get(indexMejorSeleccion);
            }
        }
        conjuntoReuniones.remove(indexMejorSeleccion);
        return aux;
    }

    public void borrarReunionesNoDisponibles(Reunion r){
        for (int i = 0; i < conjuntoReuniones.size(); i++) {
            if (r.getTiempoFin() > conjuntoReuniones.get(i).getTiempoInicio()){
                conjuntoReuniones.remove(i);
            }
        }
    }
}
