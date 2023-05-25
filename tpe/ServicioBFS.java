package tpe;

import tpe.Grafo;

import java.util.*;

public class ServicioBFS {
   private Grafo<?> grafo;

   public ServicioBFS(Grafo<?> grafo) {
      this.grafo = grafo;
   }

   public List<Integer> bfsForest() {
      Queue<Integer> q = new ArrayDeque();
      ArrayList<Integer> result = new ArrayList();
      HashMap<Integer, Boolean> visited = new HashMap<>();
      Iterator<Integer> vertices = this.grafo.obtenerVertices();
      while (vertices.hasNext()) {
         int verticeId = vertices.next();
         visited.put(verticeId, false);
      }
      Iterator<Integer> vertices2 = this.grafo.obtenerVertices();
      while (vertices2.hasNext()) {
         int verticeId = vertices2.next();
         if (visited.get(verticeId).equals(false)){
            bfs(this.grafo, verticeId, visited, q, result);
         }
      }
      return result;
   }

   private void bfs(Grafo<?> grafo, Integer verticeId, HashMap<Integer, Boolean> visited, Queue q, ArrayList<Integer> result){
      visited.put(verticeId, true);
      q.add(verticeId);
      Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeId);
      while(!q.isEmpty()){
         //System.out.println(q);
         Integer verticeActual = (Integer) q.poll();
         result.add(verticeActual);
         //q.remove();
         while(adyacentes.hasNext()){
            int ady = adyacentes.next();
            if (visited.get(ady).equals(false)){
               visited.put(ady, true);
               q.add(ady);
               //System.out.println(q);
            }
         }
      }

   }
}
