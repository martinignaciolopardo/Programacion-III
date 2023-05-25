package tpe;

import tpe.Arco;
import tpe.Grafo;

import java.util.*;

public class ServicioCaminos {
   private Grafo<?> grafo;
   private int origen;
   private int destino;
   private int lim;

   /* Dado un origen, un destino y un límite limite de saltos,
     retorna todos los caminos que, partiendo del vértice origen,
     llega al vértice de destino sin pasar por más de “lim” arcos.
     Aclaración importante: en un camino no se puede pasar 2 veces por el mismo arco. */
    public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
      this.grafo = grafo;
      this.origen = origen;
      this.destino = destino;
      this.lim = lim;
   }

   public List<List<Integer>> caminos() {
      List<List<Integer>> caminos = new ArrayList<>();
      List<Integer> caminoActual = new ArrayList<>();
      Map<Arco<?>, Boolean> visitado = new HashMap<>();

      Iterator<? extends Arco<?>> arcosIterator = grafo.obtenerArcos();
      while (arcosIterator.hasNext()) {
         Arco<?> arco = arcosIterator.next();
         visitado.put(arco, false);
      }
      if (this.grafo.contieneVertice(origen) && this.grafo.contieneVertice(destino)){
         caminosAux(origen, caminoActual, caminos, visitado);
      }
      else{
         System.out.println("no existe el origen o destino en el grafo");
      }
      return caminos;
   }

   private void caminosAux(int actual, List<Integer> caminoActual, List<List<Integer>> caminos, Map<Arco<?>, Boolean> visitado) {
      caminoActual.add(actual);
      if (caminoActual.size() - 1 <= lim) {
         if (actual == destino) {
            caminos.add(new ArrayList<>(caminoActual));
         }
         Iterator<? extends Arco<?>> arcos = grafo.obtenerArcos(actual);
         while (arcos.hasNext()) {
            Arco<?> arco = arcos.next();
            if (!visitado.get(arco)) {
               visitado.put(arco, true);
               int siguiente = arco.getVerticeDestino();
               caminosAux(siguiente, caminoActual, caminos, visitado);
               visitado.put(arco, false);
            }
         }
      }
      caminoActual.remove(caminoActual.size() - 1);
   }

}
