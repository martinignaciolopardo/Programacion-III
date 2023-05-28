import Backtracking.Ej1.SalasEj1;
import Backtracking.Ej2.Casilla;
import Backtracking.Ej2.Laberinto;
import Backtracking.Ej3.Estado;
import Backtracking.Ej3.SumaSubconjuntos;
import TPE.GrafoDirigido;
import TPE.ServicioBFS;
import TPE.ServicioCaminos;
import TPE.ServicioDFS;

import java.util.ArrayList;

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


   }
}