package Greedy.Ej5;

import TPE.GrafoNoDirigido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Problema del viajante. Dado un grafo ponderado de ciudades conectadas todas con todas,
 * implemente un algoritmo que brinde una aproximación al problema del viajante.
 */
public class Viajante {

    private GrafoNoDirigido<Integer> grafoNoDirigido;

    private Integer ciudadOrigen;
    private Integer distanciaTotal;

    public Viajante(GrafoNoDirigido<Integer> grafoNoDirigido, Integer ciudadOrigen) {
        this.grafoNoDirigido = grafoNoDirigido;
        this.ciudadOrigen = ciudadOrigen;
        distanciaTotal = 0;
    }

    public void problemaViajante() {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        ArrayList<Integer> ruta = new ArrayList();
        int cantVertices = grafoNoDirigido.cantidadVertices();
        Iterator<Integer> it = grafoNoDirigido.obtenerVertices();
        while (it.hasNext()) {
            Integer vertice = it.next();
            visited.put(vertice, false);
        }

        greedy(ciudadOrigen, visited, cantVertices, ruta);
        // se agrega la distancia del anteultimo vertice al ultimo
        Integer ultimoVertice = ruta.get(ruta.size() - 1);
        ruta.add(ciudadOrigen);
        Integer distanciaFinal = (Integer) grafoNoDirigido.obtenerArco(ultimoVertice, ciudadOrigen).getEtiqueta();
        distanciaTotal += distanciaFinal;
        System.out.println(ruta);
        System.out.println(distanciaTotal);
    }

    public void greedy(Integer verticeId, HashMap<Integer, Boolean> visited, int cantidadVertices, ArrayList<Integer> ruta) {
        visited.put(verticeId, true);
        ruta.add(verticeId);
        while(ruta.size() != cantidadVertices){
            Iterator<Integer> adyacentes = this.grafoNoDirigido.obtenerAdyacentes(verticeId);
            int menorValor = Integer.MAX_VALUE;
            Integer verticeSiguiente = null;
            while(adyacentes.hasNext()) {
                int ady = adyacentes.next();
                Integer distancia = (Integer) grafoNoDirigido.obtenerArco(verticeId, ady).getEtiqueta();
                if (distancia < menorValor && !visited.get(ady)) {
                    menorValor = distancia;
                    verticeSiguiente = ady;
                }
            }
            if (verticeSiguiente != null) {
                distanciaTotal+=menorValor;
                visited.put(verticeSiguiente, true);
                ruta.add(verticeSiguiente);
                verticeId = verticeSiguiente;
            } else {
                System.out.println("salio del bucle");
                break; // Salir del bucle si no se encuentra un vértice adyacente no visitado con distancia menor.
            }
        }
    }
}
