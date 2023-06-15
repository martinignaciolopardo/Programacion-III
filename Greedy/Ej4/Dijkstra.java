package Greedy.Ej4;

import TPE.Arco;
import TPE.Grafo;
import TPE.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;

public class Dijkstra {

    private GrafoDirigido<?> grafo;

    private Integer verticeOrigen;

    private ArrayList<Integer> dist;

    private ArrayList<Integer> padre;

    public Dijkstra(GrafoDirigido<?> grafo, Integer verticeOrigen) {
        this.grafo = grafo;
        this.verticeOrigen = verticeOrigen;
    }

    public void algoritmoGreedy(GrafoDirigido<?> grafo, Integer verticeOrigen){
        ArrayList<Integer> yaConsiderados = new ArrayList<>();
        Iterator<Integer> it = grafo.obtenerVertices();
        while(it.hasNext()){
            Integer vertice = it.next();
            dist.add(vertice, Integer.MAX_VALUE);
            padre.add(vertice, null);
        }
        dist.add(verticeOrigen, 0);

        Integer u = verticeOrigen;
        yaConsiderados.add(verticeOrigen);

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(u);
        while(adyacentes.hasNext()){
            Integer adyacente = adyacentes.next();

           // if (dist.get(u) + (dist.get(u) + ) < dist.get(adyacente))
        }

    }

}
