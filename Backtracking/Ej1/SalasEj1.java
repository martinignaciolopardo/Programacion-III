package Backtracking.Ej1;

import TPE.Arco;
import TPE.Grafo;

import java.util.*;

/**
 * Se tiene un conjunto de salas comunicadas entre sí a través de puertas que se abren solamente
 * en un sentido. Una de las salas se denomina entrada y la otra salida. Construir un algoritmo que
 * permita ir desde la entrada a la salida atravesando la máxima cantidad de salas. Idea: podría
 * representar el problema mediante un grafo dirigido, donde cada nodo es una habitación, y cada
 * puerta es un arco dirigido hacia otra habitación.
 */
public class SalasEj1 {

    private Grafo<?> grafo;
    private Integer entrada;
    private Integer salida;
    private ArrayList<Integer> caminoMasLargo = new ArrayList<>();

    public SalasEj1(Grafo<?> grafo, Integer entrada, Integer salida) {
        this.grafo = grafo;
        this.entrada = entrada;
        this.salida = salida;
    }

    public void getCaminoMasLargo(){
        Map<Arco<?>, Boolean> visitado = new HashMap<>();
        List<Integer> caminoActual = new ArrayList<>();

        Iterator<? extends Arco<?>> arcosIterator = grafo.obtenerArcos();
        while (arcosIterator.hasNext()) {
            Arco<?> arco = arcosIterator.next();
            visitado.put(arco, false);
        }
        if (grafo.contieneVertice(entrada) && grafo.contieneVertice(salida)){
            caminoMasLargoAux(entrada, caminoActual, visitado);
        }
        System.out.println(caminoMasLargo);
    }

    private void caminoMasLargoAux(int actual, List<Integer> caminoActual, Map<Arco<?>, Boolean> visitado){
        caminoActual.add(actual);
        if (caminoActual.size() > caminoMasLargo.size()){
            caminoMasLargo.clear();
            caminoMasLargo = new ArrayList<>(caminoActual);
        }
        Iterator<? extends Arco<?>> arcos = grafo.obtenerArcos(actual);
        while (arcos.hasNext()) {
            Arco<?> arco = arcos.next();
            if (!visitado.get(arco)) {
                visitado.put(arco, true);
                int siguiente = arco.getVerticeDestino();
                caminoMasLargoAux(siguiente, caminoActual, visitado);
                visitado.put(arco, false);
            }
        }
        caminoActual.remove(caminoActual.size() - 1);
    }


}
