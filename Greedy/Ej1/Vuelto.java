package Greedy.Ej1;

import java.util.ArrayList;

/**
 * Cambio de monedas. Dado un conjunto C de N tipos de monedas con un número ilimitado de
 * ejemplares de cada tipo, se requiere formar, si se puede, una cantidad M empleando el mínimo
 * número de ellas. Por ejemplo, un cajero automático dispone de billetes de distintos valores: 100$,
 * 25$, 10$, 5$ y 1$, si se tiene que pagar 289$, la mejor solución consiste en dar 10 billetes: 2 de
 * 100$, 3 de 25$, 1 de 10$ y 4 de 1$.
 */
public class Vuelto {

    public ArrayList<Integer> conjunto;

    public ArrayList<Integer> solucion;

    public Integer m;

    public Vuelto(ArrayList<Integer> conjunto, Integer m) {
        this.conjunto = conjunto;
        this.solucion = new ArrayList<>();
        this.m = m;
    }

    public void greedy(){
        while(sumaSolucion() != m){
            Integer sol = getMayorValor();
            this.solucion.add(sol);
        }
        System.out.println(this.solucion);
    }

    public int sumaSolucion(){
        int sum = 0;
        for (Integer i: this.solucion) {
            sum += i;
        }
        return sum;
    }

    public Integer getMayorValor(){
        Integer mayorValor = 0;
        for (Integer i: this.conjunto) {
            if (i > mayorValor && esValido(i)){
                mayorValor = i;
            }
        }
        return mayorValor;
    }

    public Boolean esValido(Integer i){
        return sumaSolucion() + i <= this.m;
    }

}
