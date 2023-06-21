package TPE2;

import TPE.Arco;
import TPE.Grafo;

import java.util.*;

public class ServicioBacktracking {

    private Grafo<?> grafo;
    private HashMap<Integer, ArrayList<Integer>> solucion = new HashMap<>();
    private int iteraciones;

    public ServicioBacktracking(Grafo<?> grafo) {
        this.grafo = grafo;
        this.iteraciones = 0;
    }

    public HashMap<Integer, ArrayList<Integer>> caminos() {
        List<List<Integer>> caminos = new ArrayList<>();
        List<Integer> caminoActual = new ArrayList<>();
        HashMap<Integer, Boolean> visitado = new HashMap<>();
        Integer menorDistancia = Integer.MAX_VALUE;

        Iterator<Integer> vertices = this.grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int verticeId = vertices.next();
            visitado.put(verticeId, false);
        }
        Iterator<Integer> vertices2 = this.grafo.obtenerVertices();
        while (vertices2.hasNext()) {
            int verticeId = vertices2.next();
            if (!visitado.get(verticeId)) {
                visitado.put(verticeId, true);
                encontrarCaminos(verticeId, caminoActual, caminos, visitado, menorDistancia);
            }
        }
        Integer claveMasChica = null;
        ArrayList<Integer> valorClaveMasChica = null;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : solucion.entrySet()) {
            if (claveMasChica == null || entry.getKey() < claveMasChica) {
                claveMasChica = entry.getKey();
                valorClaveMasChica = entry.getValue();
            }
        }
        System.out.println("Menor distancia: " + claveMasChica);
        System.out.println("Menor camino: " + valorClaveMasChica);
        System.out.println("iteraciones: " + iteraciones);
        return solucion;

    }

    private void encontrarCaminos(int verticeActual, List<Integer> caminoActual, List<List<Integer>> caminos, Map<Integer, Boolean> visitado, Integer menorDistancia) {
        caminoActual.add(verticeActual);
        iteraciones++;
        if (caminoActual.size() == grafo.cantidadVertices()) {
            int suma = getSuma(caminoActual);
            caminos.add(new ArrayList<>(caminoActual));
            if (suma < menorDistancia){
                menorDistancia = suma;
            }
            solucion.put(suma, new ArrayList<>(caminoActual));
        }
        //System.out.println("vertice: " + verticeActual + "Actual: " + getSuma(caminoActual) + " - Menor: "+menorDistancia);
        //if (getSuma(caminoActual) < menorDistancia){
            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeActual);
            while (adyacentes.hasNext()) {
                int verticeAdy = adyacentes.next();
                if (!visitado.get(verticeAdy)) {
                    visitado.put(verticeAdy, true);
                    encontrarCaminos(verticeAdy, caminoActual, caminos, visitado, menorDistancia);
                    visitado.put(verticeAdy, false);
                }
            }
        //}
        caminoActual.remove(caminoActual.size() - 1);
    }

    private Integer getSuma(List<Integer> caminoActual){
        int suma = 0;
        for (int i = 0; i < caminoActual.size() - 1; i++) {
            int j = i + 1;
            Arco<?> arco = grafo.obtenerArco(caminoActual.get(i), caminoActual.get(j));
            String etiquetaString = arco.getEtiqueta().toString();
            int aux = Integer.parseInt(etiquetaString);
            suma += aux;
        }
        return suma;
    }
}
