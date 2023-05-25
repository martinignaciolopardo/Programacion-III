package tpe;

import tpe.Grafo;

import java.util.*;

public class ServicioDFS {
   private Grafo<?> grafo;

   public ServicioDFS(Grafo<?> grafo) {
      this.grafo = grafo;
   }

   public List<Integer> dfsForest() {
      HashMap<Integer, String> colors = new HashMap<>();
      Iterator<Integer> vertices = this.grafo.obtenerVertices();
      ArrayList<Integer> result = new ArrayList<>();
      int tiempo;
      while (vertices.hasNext()) {
         int verticeId = vertices.next();
         colors.put(verticeId, "BLANCO");
      }
      tiempo = 0;
      Iterator<Integer> vertices2 = this.grafo.obtenerVertices();
      while(vertices2.hasNext()){
         int verticeId = vertices2.next();
         if (colors.get(verticeId).equals("BLANCO")){
            dfsVisit(verticeId, colors, tiempo, result);
         }
      }
      return result;
   }

   private void dfsVisit(Integer verticeId, HashMap colors, int tiempo, ArrayList<Integer> result){
      colors.put(verticeId, "AMARILLO");
      result.add(verticeId);
      tiempo = tiempo + 1;
      Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeId);
      while(adyacentes.hasNext()){
         int verticeAdy = adyacentes.next();
         if (colors.get(verticeAdy) == "BLANCO"){
            dfsVisit(verticeAdy, colors, tiempo, result);
         }
      }
         colors.put(verticeId, "NEGRO");
         tiempo = tiempo + 1;
   }
}
