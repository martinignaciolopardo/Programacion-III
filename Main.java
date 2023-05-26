import backtracking.SalasEj1;
import tpe.GrafoDirigido;
import tpe.ServicioBFS;
import tpe.ServicioCaminos;
import tpe.ServicioDFS;

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

      System.out.println("----------------  DFS  ----------------");

      ServicioDFS dfs = new ServicioDFS(grafo);
      System.out.println(dfs.dfsForest());

      System.out.println("--------------  CAMINOS  --------------");

      ServicioCaminos servicioCaminos = new ServicioCaminos(grafo, 1, 5, 5);
      System.out.println(servicioCaminos.caminos());


      System.out.println("---------------   BACKTRACKING   -------------------");

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

   }
}