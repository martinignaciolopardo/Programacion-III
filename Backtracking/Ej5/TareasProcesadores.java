package Backtracking.Ej5;

import java.util.ArrayList;
import java.util.HashMap;

public class TareasProcesadores {

    private int[][] asignacion;
    private HashMap<Integer, Integer> tareas;
    private int[] mejorAsignacion;
    private int mejorTiempo;

    public TareasProcesadores(HashMap<Integer, Integer> tareas) {
        this.tareas = tareas;
        asignacion = new int[tareas.size()][2];
        mejorAsignacion = new int[tareas.size()];
        mejorTiempo = Integer.MAX_VALUE;
    }

    public int[] asignarTareas() {
        backtracking(0, 0, new int[3]);
        return mejorAsignacion;
    }

    private void backtracking(int tareaActual, int tiempoActual, int[] tiemposProcesadores) {
        if (tareaActual == tareas.size()) {
            if (tiempoActual < mejorTiempo) {
                mejorTiempo = tiempoActual;
                mejorAsignacion = new int[tareas.size()];
                for (int i = 0; i < tareaActual; i++) {
                    mejorAsignacion[asignacion[i][0] - 1] = asignacion[i][1];
                }
            }
        } else {
            for (int i = 0; i < tiemposProcesadores.length; i++) {
                asignacion[tareaActual][0] = tareaActual + 1;
                asignacion[tareaActual][1] = i + 1;
                tiemposProcesadores[i] += tareas.get(tareaActual + 1);
                //backtracking(tareaActual + 1, Math.max(tiemposProcesadores[0], tiemposProcesadores[1]), tiemposProcesadores); con 2 procesadores.
                backtracking(tareaActual + 1, Math.max(Math.max(tiemposProcesadores[0], tiemposProcesadores[1]), tiemposProcesadores[2]), tiemposProcesadores);
                tiemposProcesadores[i] -= tareas.get(tareaActual + 1);
            }
        }
    }

}
