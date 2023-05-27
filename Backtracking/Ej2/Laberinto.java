package Backtracking.Ej2;

import java.util.ArrayList;
import java.util.List;

/**
 * Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural
 * y cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este,
 * sur y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud
 * de un camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría
 * representarse el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y
 * cuatro booleanos, uno para cada dirección a la que se permite ir desde allí.
 */
public class Laberinto {

    private Casilla[][] matriz;

    public Laberinto(Casilla[][] matriz) {
        this.matriz = matriz;
    }

    public Casilla getCasilla(int fila, int columna) {
        return matriz[fila][columna];
    }

    private boolean isValidCasilla(int fila, int columna) {
        return fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz.length;
    }

    public void getShortestPath(int filaInicio, int columnaInicio, int filaFin, int columnaFin){
        List<Integer> caminoActual = new ArrayList<>();
        List<Integer> mejorCamino = new ArrayList<>();

        backtrack(filaInicio, columnaInicio, filaFin, columnaFin, caminoActual, mejorCamino);

        if (mejorCamino.isEmpty()) {
            System.out.println("No se encontró un camino válido.");
        }
        else{
            System.out.println(mejorCamino);
        }
    }

    private void backtrack(int filaActual, int columnaActual, int filaFin, int columnaFin, List<Integer> caminoActual, List<Integer> mejorCamino) {
        Casilla casillaActual = matriz[filaActual][columnaActual];

        casillaActual.setVisitada(true);
        caminoActual.add(casillaActual.getValor());

        if (filaActual == filaFin && columnaActual == columnaFin){
            // Verificar si el camino actual es mejor que el camino anteriormente encontrado
            if (mejorCamino.isEmpty() || caminoActual.size() < mejorCamino.size()) {
                mejorCamino.clear();
                mejorCamino.addAll(caminoActual);
            }
            return;
        }



        if (casillaActual.isNorte() && isValidCasilla(filaActual - 1, columnaActual) && !matriz[filaActual - 1][columnaActual].isVisitada()) {
            backtrack(filaActual - 1, columnaActual, filaFin, columnaFin, caminoActual, mejorCamino);
        }

        if (casillaActual.isEste() && isValidCasilla(filaActual, columnaActual + 1) && !matriz[filaActual][columnaActual + 1].isVisitada()) {
            backtrack(filaActual, columnaActual + 1, filaFin, columnaFin, caminoActual, mejorCamino);
        }

        if (casillaActual.isOeste() && isValidCasilla(filaActual, columnaActual - 1) && !matriz[filaActual][columnaActual - 1].isVisitada()) {
            backtrack(filaActual, columnaActual - 1, filaFin, columnaFin, caminoActual, mejorCamino);
        }

        if (casillaActual.isSur() && isValidCasilla(filaActual + 1, columnaActual) && !matriz[filaActual + 1][columnaActual].isVisitada()) {
            backtrack(filaActual + 1, columnaActual, filaFin, columnaFin, caminoActual, mejorCamino);
        }

        casillaActual.setVisitada(false);
        caminoActual.remove(caminoActual.size() - 1);
    }

}
