package Backtracking.Ej6;

import Backtracking.Ej2.Casilla;
import TPE.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Caballo de Atila. Por donde pisa el caballo de Atila jamás vuelve a crecer el pasto. El caballo fue
 * directamente hacia el jardín de n x n casillas. Empezó su paseo por una casilla cualquiera y volvió
 * a ella, es decir hizo un recorrido cerrado. No visitó dos veces una misma casilla, se movió de una
 * casilla a otra vecina en forma horizontal o vertical, pero nunca en diagonal. Por donde pisó el
 * caballo, el pasto jamás volvió a crecer. Luego de terminado el recorrido en algunas casillas
 * todavía había pasto (señal de que en ellas no había estado el caballo). Escriba un algoritmo que
 * deduzca el recorrido completo que hizo el caballo.
 */
public class CaballoAtila {
    private Grafo<?> grafo;
    private ArrayList<Integer> res = new ArrayList<>();
    private ArrayList<Integer> pisadas;

    public CaballoAtila(Grafo<?> grafo, ArrayList<Integer> pisadas) {
        this.grafo = grafo;
        this.pisadas = pisadas;
    }

    public ArrayList<Integer> getCamino(){
        HashMap<Integer, Boolean> visitado = new HashMap<>();
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()){
            visitado.put(vertices.next(), false);
        }

        Iterator<Integer> verticeActualIterator = grafo.obtenerVertices();
        while(verticeActualIterator.hasNext()){
            Integer verticeActual = verticeActualIterator.next();
            if (!visitado.get(verticeActual)){
                backtrack(verticeActual, visitado);
            }
        }
        return res;
    }

    private void backtrack(Integer verticeActual, HashMap<Integer, Boolean> visitado){
        visitado.put(verticeActual, true);
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(verticeActual);
        if (pisadas.contains(verticeActual) && !res.contains(verticeActual)){
            res.add(verticeActual);
        }
        while(adyacentes.hasNext()){
            Integer adyacente = adyacentes.next();
            if (!visitado.get(adyacente)){
                if (pisadas.contains(verticeActual) && !res.contains(verticeActual)){
                    res.add(verticeActual);
                }
                backtrack(adyacente, visitado);
            }
        }
    }

}
