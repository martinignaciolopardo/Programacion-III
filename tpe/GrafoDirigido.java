package tpe;

import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {

   private HashMap<Integer, HashMap<Integer, Arco<T>>> vertices;

   public GrafoDirigido() {
      vertices = new HashMap<>();
   }

   /**
    * Complejidad: O(1) ya que los metodos del grafo son O(1),
    * en este caso:
    * containsKey() -> que verifica que exista la key en el hashmap (Si existe el vertice)
    * y put() -------> que agrega una key al hashmap.
    */
   @Override
   public void agregarVertice(int verticeId) {
      if (!vertices.containsKey(verticeId)) {
         vertices.put(verticeId, new HashMap<Integer, Arco<T>>());
      }
   }

   /**
    * Complejidad: O(n) donde n es la cantidad de vertices.
    * Tiene que recorrer todos los vertices para ver si existe.
    * Elimina el vertice y los arcos que parten del mismo.
    * containsKey() -> verifica que exista la key en un hasmap O(1)
    * remove() ------> elimina una key del hasmap O(1)
    */
   @Override
   public void borrarVertice(int verticeId) {
      if (vertices.containsKey(verticeId)) {
         for (Integer v : vertices.keySet()) {
            if (vertices.get(v).containsKey(verticeId)) {
               vertices.get(v).remove(verticeId);
            }
         }
         vertices.remove(verticeId);
      }
   }

   /**
    * Complejidad: O(1) ya que los metodos del grafo son O(1),
    * en este caso:
    * containsKey() -> verifica que exista la key en un hasmap O(1)
    * y put() -------> que agrega una key al hashmap O(1)
    * existeArco es O(1) explicado mas adelante.
    */
   @Override
   public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
      if (!existeArco(verticeId1, verticeId2)) {
         HashMap<Integer, Arco<T>> arcosOrigen = vertices.get(verticeId1);
         if (arcosOrigen == null) {
            arcosOrigen = new HashMap<>();
            vertices.put(verticeId1, arcosOrigen);
         }
         arcosOrigen.put(verticeId2, new Arco<T>(verticeId1, verticeId2, etiqueta));
      } else {
         System.out.println("No se pudo agregar el arco porque ya existe uno entre el vertice " + verticeId1 + " y " + verticeId2);
      }
   }

   /**
    * Complejidad: O(1) ya que los metodos del grafo son O(1),
    * en este caso:
    * get() -> obtiene el valor mapeado de una key O(1)
    * remove() ------> elimina una key del hasmap O(1)
    * existeArco es O(1) explicado mas adelante.
    */
   @Override
   public void borrarArco(int verticeId1, int verticeId2) {
      if (existeArco(verticeId1, verticeId2)) {
         vertices.get(verticeId1).remove(verticeId2);
      } else {
         System.out.println("No se pudo eliminar el arco porque no existe");
      }
   }

   /**
    * Complejidad: O(1) ya que los metodos del grafo son O(1),
    * en este caso:
    * containsKey() -> verifica que exista la key en un hasmap O(1)
    */
   @Override
   public boolean contieneVertice(int verticeId) {
      return vertices.containsKey(verticeId);
   }

   /**
    * Complejidad: O(1) ya que los metodos del grafo son O(1),
    * en este caso:
    * containsKey() -> verifica que exista la key en un hasmap O(1)
    * get() -> obtiene el valor mapeado de una key O(1)
    */
   @Override
   public boolean existeArco(int verticeId1, int verticeId2) {
      if (vertices.containsKey(verticeId1)) {
         if (vertices.get(verticeId1).containsKey(verticeId2)) {
            return true;
         }
      }
      return false;
   }

   /**
    * Complejidad: O(1) ya que los metodos del grafo son O(1),
    * en este caso:
    * get() -> obtiene el valor mapeado de una key O(1)
    * existeArco es O(1) explicado mas arriba
    */
   @Override
   public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
      if (existeArco(verticeId1, verticeId2)) {
         return vertices.get(verticeId1).get(verticeId2);
      } else {
         System.out.println("No se puede devolver el arco porque no existe");
         return null;
      }
   }

   /**
    * Complejidad: O(1) ya que el metodo
    * size() del grafo es O(1)
    */
   @Override
   public int cantidadVertices() {
      return vertices.size();
   }

   /**
    * Complejidad: O(n) donde n es la cantidad de vertices
    * get() --> obtiene el valor mapeado de una key O(1)
    * size() -> O(1)
    */
   @Override
   public int cantidadArcos() {
      int res = 0;
      for (Integer v : vertices.keySet()) {
         res += vertices.get(v).size();
      }
      return res;
   }

   /**
    * Complejidad: O(1) debido a que devuelve un iterador O(1)
    * pero no se esta iterando el mismo
    */
   @Override
   public Iterator<Integer> obtenerVertices() {
      return vertices.keySet().iterator();
   }

   /**
    * Complejidad: O(1) debido a que devuelve un iterador O(1)
    * pero no se esta iterando el mismo
    */
   @Override
   public Iterator<Integer> obtenerAdyacentes(int verticeId) {
      return vertices.get(verticeId).keySet().iterator();
   }

   /**
    * Complejidad: O(n) donde n es la cantidad de vertices
    * ya que se debe iterar por cada vertice del hashmap
    * get() --> obtiene el valor mapeado de una key O(1)
    * values() -> devuelve todos los valores del hasmap O(1)
    */
   @Override
   public Iterator<Arco<T>> obtenerArcos() {
      List c = new ArrayList<Arco<T>>();
      for (Integer v : vertices.keySet()) {
         c.addAll(vertices.get(v).values());
      }
      return c.iterator();
   }

   /**
    * Complejidad: O(1) debido a que devuelve un iterador O(1)
    * contieneVertice(Integer) -> O(1)
    * get() --> obtiene el valor mapeado de una key O(1)
    * values() -> devuelve todos los valores del hasmap O(1)
    */
   @Override
   public Iterator<Arco<T>> obtenerArcos(int verticeId) {
      List c = new ArrayList<Arco<T>>();
      if (contieneVertice(verticeId)) {
         c.addAll(vertices.get(verticeId).values());
      }
      return c.iterator();
   }

}
