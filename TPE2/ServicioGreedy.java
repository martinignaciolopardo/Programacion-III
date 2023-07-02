package TPE2;

import TPE.Arco;
import TPE.Grafo;
import TPE.GrafoNoDirigido;

import java.util.*;

public class ServicioGreedy {
    private Grafo<?> grafo;

    Integer cantVertices;

    int iteraciones;

    int menorDistancia;

    public ServicioGreedy(GrafoNoDirigido<Integer> grafoNoDirigido) {
        this.grafo = grafoNoDirigido;
        this.cantVertices = grafo.cantidadVertices();
        this.iteraciones = 0;
        this.menorDistancia = 0;
    }

    public ArrayList<String> camino() {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        ArrayList<Arco<?>> caminoSolucion = new ArrayList();

        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()) {
            Integer vertice = it.next();
            visited.put(vertice, false);
        }

        Iterator<Integer> it2 = grafo.obtenerVertices();

        Integer verticeInicio = it2.next();
        greedy(verticeInicio, visited, caminoSolucion);

        ArrayList<String> solucion = new ArrayList<>();
        for (Arco<?> arco : caminoSolucion) {
            solucion.add(arco.getVerticeOrigen() + "-" + arco.getVerticeDestino());
        }
        return solucion;
    }

    public void greedy(Integer verticeId, HashMap<Integer, Boolean> visited, ArrayList<Arco<?>> caminoSolucion) {
        visited.put(verticeId, true);
        while (caminoSolucion.size() != cantVertices -1) {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(verticeId);
            int menorValor = Integer.MAX_VALUE;
            Integer verticeSiguiente = null;
            while (adyacentes.hasNext()) {
                int ady = adyacentes.next();
                Integer distancia = (Integer) grafo.obtenerArco(verticeId, ady).getEtiqueta();
                if (distancia < menorValor && !visited.get(ady)) {
                    menorValor = distancia;
                    verticeSiguiente = ady;
                }
                iteraciones++;
            }
            if (verticeSiguiente != null){
                menorDistancia += (Integer) grafo.obtenerArco(verticeId, verticeSiguiente).getEtiqueta();
                visited.put(verticeSiguiente, true);
                Arco<?> a = grafo.obtenerArco(verticeId, verticeSiguiente);
                caminoSolucion.add(a);
                verticeId = verticeSiguiente;
            }
            else {
                break;
            }
        }
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public int getMenorDistancia() {
        return menorDistancia;
    }
}
