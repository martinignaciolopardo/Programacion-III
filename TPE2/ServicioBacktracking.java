package TPE2;

import TPE.Arco;
import TPE.Grafo;
import TPE.GrafoNoDirigido;

import java.util.*;

public class ServicioBacktracking {

    private Grafo<?> grafo;
    private HashMap<Integer, ArrayList<Integer>> solucion = new HashMap<>();
    private int iteraciones;
    private int menorDistancia;
    private int cantVertices;

    private List<Arco<?>> mejorSolucion;

    private ArrayList<Integer> verticesGrafo = new ArrayList<>();

    private int distanciaGreedy;

    public ServicioBacktracking(Grafo<?> grafo) {
        this.grafo = grafo;
        this.iteraciones = 0;
        this.menorDistancia = Integer.MAX_VALUE;
        this.cantVertices = grafo.cantidadVertices();
    }

    public ArrayList<String> caminos() {
        ArrayList<Arco<?>> caminoActual = new ArrayList<>();
        mejorSolucion = new ArrayList<>();
        HashMap<Arco<?>, Boolean> arcoVisitado = new HashMap<>();
        ArrayList<Integer> visitado = new ArrayList<>();
        //ServicioGreedy s = new ServicioGreedy((GrafoNoDirigido<Integer>) grafo);
        //s.camino();
        //int distanciaGreedy = s.getMenorDistancia();

        Iterator<? extends Arco<?>> arcos = this.grafo.obtenerArcos();
        while (arcos.hasNext()) {
            Arco<?> arco = arcos.next();
            arcoVisitado.put(arco, false);
        }
        Iterator<Integer> vertices = this.grafo.obtenerVertices();
        int vertice = vertices.next();
        visitado.add(vertice);
        encontrarMejorCamino(vertice, caminoActual, visitado, arcoVisitado, 0, 0);

        ArrayList<String> solucion = new ArrayList<>();
        for (Arco<?> arco : mejorSolucion) {
            solucion.add(arco.getVerticeOrigen() + "-" + arco.getVerticeDestino());
        }
        return solucion;

    }

    private void encontrarMejorCamino(int verticeActual, List<Arco<?>> caminoActual, List<Integer> visitado, Map<Arco<?>, Boolean> arcoVisitado, int distActual, int cantArcos) {
        if (distActual < distanciaGreedy) {
            boolean flag = false;
            if (visitado.size() == cantVertices) {
                if (distActual < menorDistancia) {
                    mejorSolucion.clear();
                    mejorSolucion.addAll(caminoActual);
                    menorDistancia = distActual;
                }
            } else {
                int arcosRestantes = cantVertices - visitado.size();
                int arcosMaximos = menorDistancia - distActual;
                if (cantArcos + arcosRestantes > arcosMaximos) {
                    return;
                }
                List<Arco<?>> arcosNoVisitados = new ArrayList<>();
                Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeActual);
                while (adyacentes.hasNext()) {
                    iteraciones++;
                    Integer ady = adyacentes.next();
                    Arco<?> arco = grafo.obtenerArco(verticeActual, ady);
                    if (!arcoVisitado.get(arco) && !caminoActual.contains(arco)) {
                        arcosNoVisitados.add(arco);
                    }
                }
                for (Arco<?> arco : arcosNoVisitados) {
                    Integer ady = arco.getVerticeDestino();
                    Arco<?> arco2 = grafo.obtenerArco(ady, verticeActual);

                    if (!visitado.contains(ady)) {
                        visitado.add(ady);
                        flag = true;
                    }

                    if (!caminoActual.contains(arco2)) {
                        caminoActual.add(arco);
                        distActual += (Integer) arco.getEtiqueta();
                    }
                    arcoVisitado.put(arco, true);

                    encontrarMejorCamino(ady, caminoActual, visitado, arcoVisitado, distActual, +1);

                    if (flag) {
                        visitado.remove(ady);
                        flag = false;
                    }

                    if (!caminoActual.contains(arco2)) {
                        caminoActual.remove(arco);
                        distActual -= (Integer) arco.getEtiqueta();
                    }
                    arcoVisitado.put(arco, false);
                }
            }
        }
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public int getMenorDistancia() {
        return menorDistancia;
    }

    public int getDistanciaGreedy() {
        return distanciaGreedy;
    }

    public void setDistanciaGreedy(int distanciaGreedy) {
        this.distanciaGreedy = distanciaGreedy;
    }
}
