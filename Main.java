import Backtracking.Ej1.SalasEj1;
import Backtracking.Ej10.ZeroSumSubsets;
import Backtracking.Ej2.Casilla;
import Backtracking.Ej2.Laberinto;
import Backtracking.Ej3.SumaSubconjuntos;
import Backtracking.Ej5.TareasProcesadores;
import Backtracking.Ej6.CaballoAtila;
import Greedy.Ej1.Vuelto;
import Greedy.Ej2.MochilaFraccionaria;
import Greedy.Ej2.ObjetoFraccionario;
import Greedy.Ej3.ActividadesCompatibles;
import Greedy.Ej3.Reunion;
import Greedy.Ej6.Viajante;
import Greedy.Ej7.CazadorLeones;
import Greedy.Ej8.ArmandoCDs;
import Greedy.Ej8.Cancion;
import TPE.*;
import TPE2.CSVReader;

import java.util.ArrayList;
import java.util.HashMap;

import static Backtracking.Ej4.ConjuntosDisjuntos.canPartition;

public class Main {
   public static void main(String[] args) {

      GrafoDirigido<String> grafo = new GrafoDirigido<>();

      grafo.agregarVertice(1);
      grafo.agregarVertice(2);
      grafo.agregarVertice(3);
      grafo.agregarVertice(4);
      grafo.agregarVertice(5);
      grafo.agregarVertice(6);
      grafo.agregarVertice(7);
      grafo.agregarVertice(8);
      grafo.agregarVertice(9);
      grafo.agregarVertice(10);

      grafo.agregarArco(1, 3, "C");
      grafo.agregarArco(1, 7, "L");
      grafo.agregarArco(1, 4, "H");
      grafo.agregarArco(2, 4, "A");
      grafo.agregarArco(2, 5, "B");
      grafo.agregarArco(3, 2, "E");
      grafo.agregarArco(5, 2, "O");
      grafo.agregarArco(5, 6, "D");
      grafo.agregarArco(6, 7, "F");
      grafo.agregarArco(6, 10, "K");
      grafo.agregarArco(7, 8, "G");
      grafo.agregarArco(8, 9, "I");
      grafo.agregarArco(9, 10, "J");
      grafo.agregarArco(10, 5, "Z");
      grafo.agregarArco(10, 4, "W");

      System.out.println("----------------  BFS  ----------------");

      ServicioBFS bfs = new ServicioBFS(grafo);
      System.out.println(bfs.bfsForest());

      System.out.println("\n----------------  DFS  ----------------");

      ServicioDFS dfs = new ServicioDFS(grafo);
      System.out.println(dfs.dfsForest());

      System.out.println("\n--------------  CAMINOS  --------------");

      ServicioCaminos servicioCaminos = new ServicioCaminos(grafo, 1, 5, 5);
      System.out.println(servicioCaminos.caminos());


      System.out.println("\n\n---------------   BACKTRACKING   -------------------\n");

      System.out.println("EJ1: Salas");

      GrafoDirigido<String> grafoB = new GrafoDirigido<>();
      grafoB.agregarVertice(1);
      grafoB.agregarVertice(2);
      grafoB.agregarVertice(3);
      grafoB.agregarVertice(4);
      grafoB.agregarVertice(5);
      grafoB.agregarVertice(6);
      grafoB.agregarVertice(7);
      grafoB.agregarVertice(8);
      grafoB.agregarVertice(9);
      grafoB.agregarArco(1, 3, "C");
      grafoB.agregarArco(1, 4, "L");
      grafoB.agregarArco(2, 9, "A");
      grafoB.agregarArco(2, 5, "B");
      grafoB.agregarArco(3, 7, "E");
      grafoB.agregarArco(4, 8, "G");
      grafoB.agregarArco(4, 6, "I");
      grafoB.agregarArco(5, 9, "J");
      grafoB.agregarArco(6, 2, "K");
      grafoB.agregarArco(6, 5, "J");
      grafoB.agregarArco(7, 8, "O");
      grafoB.agregarArco(8, 4, "D");
      grafoB.agregarArco(8, 2, "F");

      SalasEj1 ej1 = new SalasEj1(grafoB, 1,9);
      ej1.getCaminoMasLargo();

      System.out.println("\nEj2: Laberinto");

      Casilla[][] matrizLaberinto = new Casilla[5][5];

      matrizLaberinto[0][0] = new Casilla(1, false, false, true, false);
      matrizLaberinto[0][1] = new Casilla(2, false, true, true, false);
      matrizLaberinto[0][2] = new Casilla(3, false, true, false, true);
      matrizLaberinto[0][3] = new Casilla(4, false, true, false, true);
      matrizLaberinto[0][4] = new Casilla(5, false, false, true, true);

      matrizLaberinto[1][0] = new Casilla(6, true, true, false, false);
      matrizLaberinto[1][1] = new Casilla(7, true, false, false, true);
      matrizLaberinto[1][2] = new Casilla(8, false, true, true, false);
      matrizLaberinto[1][3] = new Casilla(9, false, false, true, true);
      matrizLaberinto[1][4] = new Casilla(10, true, false, true, false);

      matrizLaberinto[2][0] = new Casilla(11, false, true, true, false);
      matrizLaberinto[2][1] = new Casilla(12, false, true, false, true);
      matrizLaberinto[2][2] = new Casilla(13, true, false, false, true);
      matrizLaberinto[2][3] = new Casilla(14, true, true, false, false);
      matrizLaberinto[2][4] = new Casilla(15, true, false, true, true);

      matrizLaberinto[3][0] = new Casilla(16, true, false, true, false);
      matrizLaberinto[3][1] = new Casilla(17, false, true, false, false);
      matrizLaberinto[3][2] = new Casilla(18, false, true, true, true);
      matrizLaberinto[3][3] = new Casilla(19, false, false, true, true);
      matrizLaberinto[3][4] = new Casilla(20, true, false, true, false);

      matrizLaberinto[4][0] = new Casilla(21, true, true, false, false);
      matrizLaberinto[4][1] = new Casilla(22, false, false, false, true);
      matrizLaberinto[4][2] = new Casilla(23, true, false, false, false);
      matrizLaberinto[4][3] = new Casilla(24, true, true, false, false);
      matrizLaberinto[4][4] = new Casilla(25, true, false, false, true);


      Laberinto laberinto = new Laberinto(matrizLaberinto);
      laberinto.getShortestPath(0, 0,4,4);

      System.out.println("\nEj3: Suma de Subconjuntos");

      ArrayList<Integer> conjunto = new ArrayList<>();
      conjunto.add(1);
      conjunto.add(4);
      conjunto.add(3);
      conjunto.add(2);
      conjunto.add(8);
      conjunto.add(10);
      conjunto.add(6);
      conjunto.add(5);
      Integer resultado = 7;

      SumaSubconjuntos sumaSub = new SumaSubconjuntos(conjunto, resultado);
      sumaSub.getSumaSubconjuntos();

      System.out.println("\nEj4: Conjuntos disjuntos");

      int[] nums = {2, 3, 6, 1};
      boolean canPartition = canPartition(nums);
      if (canPartition) {
         System.out.println("Se encontró una partición.");
      } else {
         System.out.println("No se encontró una partición.");
      }

      System.out.println("\nEj5: Procesadores");

      HashMap<Integer, Integer> tareas = new HashMap<>();
      tareas.put(1, 5);  // Tarea con ID 1 y tiempo de procesamiento 5
      tareas.put(2, 3);  // Tarea con ID 2 y tiempo de procesamiento 3
      tareas.put(3, 7);  // Tarea con ID 3 y tiempo de procesamiento 7
      tareas.put(4, 12);  // Tarea con ID 4 y tiempo de procesamiento 12
      tareas.put(5, 2);  // Tarea con ID 5 y tiempo de procesamiento 2
      tareas.put(6, 3);  // Tarea con ID 6 y tiempo de procesamiento 3

      TareasProcesadores tp = new TareasProcesadores(tareas);
      int[] asignacionOptima = tp.asignarTareas();
      System.out.println("Asignación óptima:");
      for (int i = 0; i < asignacionOptima.length; i++) {
         System.out.println("Tarea " + (i + 1) + " asignada al procesador " + asignacionOptima[i]);
      }

      System.out.println("\nEj6: Caballo de Atila");

      GrafoNoDirigido<String> grafoAtila = new GrafoNoDirigido<>();

      for (int i = 1; i <= 9; i++) {
         grafoAtila.agregarVertice(i);
      }

      grafoAtila.agregarArco(1, 2, "A");
      grafoAtila.agregarArco(1, 4, "B");
      grafoAtila.agregarArco(2, 5, "K");
      grafoAtila.agregarArco(3, 2, "C");
      grafoAtila.agregarArco(3, 6, "D");
      grafoAtila.agregarArco(4, 5, "M");
      grafoAtila.agregarArco(6, 5, "Q");
      grafoAtila.agregarArco(6, 9, "H");
      grafoAtila.agregarArco(7, 8, "E");
      grafoAtila.agregarArco(7, 4, "F");
      grafoAtila.agregarArco(8, 5, "S");
      grafoAtila.agregarArco(9, 8, "G");

      ArrayList<Integer> pisadas = new ArrayList<>();
      pisadas.add(1);   // x x x
      pisadas.add(2);   // x   x
      pisadas.add(3);   // x x x
      pisadas.add(4);
      pisadas.add(6);
      pisadas.add(7);
      pisadas.add(8);
      pisadas.add(9);

      CaballoAtila caballoAtila = new CaballoAtila(grafoAtila, pisadas);

      System.out.println(caballoAtila.getCamino());

      System.out.println("\nEj10: zero");

      int[] subSet = {1,2,-3,4,-5,6,8,10};
      int subSetSize = 3;
      ZeroSumSubsets zero = new ZeroSumSubsets(subSet, subSetSize);
      System.out.println(zero.findSubsets());

      /*-------------------------------------- GREEDY ----------------------------------------*/

      System.out.println("GREEDY");
      System.out.println("\nEJ1: VUELTO");

      ArrayList<Integer> conj = new ArrayList<>();
      conj.add(100);
      conj.add(25);
      conj.add(10);
      conj.add(5);
      conj.add(1);
      Vuelto v = new Vuelto(conj, 289);
      v.greedy();

      System.out.println("\nEJ2: MOCHILA");

      ArrayList<ObjetoFraccionario> objetos = new ArrayList<>();
      ObjetoFraccionario pan = new ObjetoFraccionario(18D,25D, "pan");
      ObjetoFraccionario milanesa = new ObjetoFraccionario(15D,24D, "milanesa");
      ObjetoFraccionario mayonesa = new ObjetoFraccionario(10D,15D, "mayonesa");
      objetos.add(pan);
      objetos.add(milanesa);
      objetos.add(mayonesa);

      MochilaFraccionaria mochi = new MochilaFraccionaria(objetos, 20D);
      mochi.greedy();

      System.out.println("\nEJ3: REUNIONES");


      Reunion r1 = new Reunion("a", 13,14);
      Reunion r2 = new Reunion("b", 15,19);
      Reunion r3 = new Reunion("c", 15,16);
      Reunion r4 = new Reunion("d", 18,19);
      Reunion r5 = new Reunion("e", 19,22);
      Reunion r6 = new Reunion("f", 16,17);
      ArrayList<Reunion> reuniones = new ArrayList<>();
      reuniones.add(r1);
      reuniones.add(r2);
      reuniones.add(r3);
      reuniones.add(r4);
      reuniones.add(r5);
      reuniones.add(r6);

      ActividadesCompatibles ac = new ActividadesCompatibles(reuniones);
      ac.greedy();

      System.out.println("\nEJ4: DIJKSTRA");

      System.out.println("\nEJ5: VIAJANTE");

      GrafoNoDirigido grafoViajante = new GrafoNoDirigido();
      grafoViajante.agregarVertice(1);
      grafoViajante.agregarVertice(2);
      grafoViajante.agregarVertice(3);
      grafoViajante.agregarVertice(4);
      grafoViajante.agregarVertice(5);
      grafoViajante.agregarVertice(6);
      grafoViajante.agregarVertice(7);
      grafoViajante.agregarVertice(8);
      grafoViajante.agregarArco(1,3,20);
      grafoViajante.agregarArco(3,2,25);
      grafoViajante.agregarArco(3,4,30);
      grafoViajante.agregarArco(5,4,5);
      grafoViajante.agregarArco(6,4,15);
      grafoViajante.agregarArco(6,1,5);
      grafoViajante.agregarArco(7,1,10);
      grafoViajante.agregarArco(7,2,10);
      grafoViajante.agregarArco(8,5,40);
      grafoViajante.agregarArco(8,6,35);

      Viajante viajante = new Viajante(grafoViajante, 4);
      viajante.problemaViajante();

      System.out.println("\nEJ6: CAZADOR DE LEONES");

      ArrayList<Boolean> cazadoresAndLeones = new ArrayList<>();
      cazadoresAndLeones.add(true);
      cazadoresAndLeones.add(false);
      cazadoresAndLeones.add(true);
      cazadoresAndLeones.add(true);
      cazadoresAndLeones.add(true);
      cazadoresAndLeones.add(false);
      cazadoresAndLeones.add(true);

      Integer pasos = 4;

      CazadorLeones c = new CazadorLeones(cazadoresAndLeones, pasos);
      c.cazar();

      System.out.println("\nEJ6: GRABAR CD");

      Cancion c1 = new Cancion("Solo aqui", "Rock", 4.34, 5.35);
      Cancion c2 = new Cancion("Esta saliendo el sol", "Rock", 4.12, 4.92);
      Cancion c3 = new Cancion("Religion", "Rock", 4.41, 5.49);
      Cancion c4 = new Cancion("Hay momentos", "Rock", 4.46, 5.39);
      Cancion c5 = new Cancion("Nothing else matters", "Rock", 6.26, 7.54);
      Cancion c6 = new Cancion("Enter sandman", "Rock", 5.31, 6.46);

      ArrayList<Cancion> conjuntoCanciones = new ArrayList<>();
      conjuntoCanciones.add(c1);
      conjuntoCanciones.add(c2);
      conjuntoCanciones.add(c3);
      conjuntoCanciones.add(c4);
      conjuntoCanciones.add(c5);
      conjuntoCanciones.add(c6);

      Double capacidad = 23.59;

      ArmandoCDs cdEspacio = new ArmandoCDs(conjuntoCanciones, capacidad);

      cdEspacio.maximizarEspacio();

      Cancion cc1 = new Cancion("Solo aqui", "Rock", 4.34, 5.35);
      Cancion cc2 = new Cancion("Esta saliendo el sol", "Rock", 4.12, 4.92);
      Cancion cc3 = new Cancion("Religion", "Rock", 4.41, 5.49);
      Cancion cc4 = new Cancion("Hay momentos", "Rock", 4.46, 5.39);
      Cancion cc5 = new Cancion("Nothing else matters", "Rock", 6.26, 7.54);
      Cancion cc6 = new Cancion("Enter sandman", "Rock", 5.31, 6.46);

      ArrayList<Cancion> conjuntoCanciones2 = new ArrayList<>();
      conjuntoCanciones2.add(cc1);
      conjuntoCanciones2.add(cc2);
      conjuntoCanciones2.add(cc3);
      conjuntoCanciones2.add(cc4);
      conjuntoCanciones2.add(cc5);
      conjuntoCanciones2.add(cc6);

      ArmandoCDs cdCantidad = new ArmandoCDs(conjuntoCanciones2, capacidad);
      cdCantidad.maximizarCantidad();

      System.out.println("\nTPE PARTE 2: ");

      CSVReader csv = new CSVReader("src/TPE2/datasets/dataset1.txt");
      csv.read();

   }
}