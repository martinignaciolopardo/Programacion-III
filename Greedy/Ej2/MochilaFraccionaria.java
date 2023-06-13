package Greedy.Ej2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Problema de la Mochila. Se tienen n objetos y una mochila. Para i = 1,2,..n, el objeto i tiene un
 * peso positivo pi y un valor positivo vi. La mochila puede llevar un peso que no sobrepase P. El
 * objetivo es llenar la mochila de tal manera que se maximice el valor de los objetos transportados,
 * respetando la limitación de capacidad impuesta. Los objetos pueden ser fraccionados, si una
 * fracción xi (0 ≤ xi ≤ 1) del objeto i es ubicada en la mochila contribuye en xipi al peso total de la
 * mochila y en xivi al valor de la carga. Formalmente, el problema puede ser establecido como.
 * Maximizar i = xivi , con la restricción i = xipi ≤ P donde vi>0, pi>0 y 0 ≤ xi ≤ 1 para 1 ≤ i ≤ n.
 */
public class MochilaFraccionaria {

    private ArrayList<ObjetoFraccionario> elementos;

    private Double pesoMochila;

    private ArrayList<ObjetoFraccionario> solucion;

    public MochilaFraccionaria(ArrayList<ObjetoFraccionario> elementos, Double pesoMochila) {
        this.elementos = elementos;
        this.pesoMochila = pesoMochila;
        this.solucion = new ArrayList<>();
    }

    public void greedy() {
        while (!elementos.isEmpty() && getSuma() <= this.pesoMochila) {
            Integer indexMejorProducto = encontrarMejorProducto();
            if (indexMejorProducto == null) {
                break;
            }
            agregarProducto(indexMejorProducto);
        }
        for (ObjetoFraccionario e: this.solucion) {
            System.out.println(e.getPeso() + "kg de " + e.getNombre());
        }
        //while (getSuma() <= this.pesoMochila) {
        //    Integer idexMejorProducto = encontrarMejorProducto();
        //    agregarProducto(idexMejorProducto);
        //}
        //for (ObjetoFraccionario e: this.solucion) {
        //    System.out.println(e.getPeso() +"kg de "+ e.getNombre());
        //}
    }

    public Double getSuma() {
        Double sum = 0D;
        for (ObjetoFraccionario e : this.solucion) {
            sum += e.getPeso();
        }
        return sum;
    }

    public Integer encontrarMejorProducto() {
        Double mejorProducto = -Double.MAX_VALUE;
        Integer indexMejorProd = null;
        int index = 0; // Inicializar el índice a 0
        Iterator<ObjetoFraccionario> iterator = this.elementos.iterator();
        while (iterator.hasNext()) {
            ObjetoFraccionario e = iterator.next();
            Double productoActual = e.getValor() / e.getPeso();
            if (productoActual > mejorProducto) {
                mejorProducto = productoActual;
                indexMejorProd = index;
            }
            index++; // Incrementar el índice después de cada iteración
        }
        return indexMejorProd;
    }

    public void agregarProducto(Integer i) {
        Iterator<ObjetoFraccionario> iterator = this.elementos.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            ObjetoFraccionario e = iterator.next();
            if (index == i) {
                double pesoRestante = this.pesoMochila - getSuma();
                double fraccion = Math.min(pesoRestante / e.getPeso(), 1.0);
                double pesoProducto = e.getPeso() * fraccion;

                if (pesoProducto > 0) {
                    ObjetoFraccionario producto = new ObjetoFraccionario(pesoProducto, e.getValor() * fraccion, e.getNombre());
                    this.solucion.add(producto);
                }

                iterator.remove();
                break;
            }
            index++;
        }
    }

}
