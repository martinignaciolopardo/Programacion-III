package Greedy.Ej7;

import java.util.ArrayList;

public class CazadorLeones {

    private ArrayList<Boolean> cazadoresAndLeones;
    private ArrayList<Integer> leonesCazados;
    private Integer totalCazados;

    private Integer pasos;

    public CazadorLeones(ArrayList<Boolean> cazadoresAndLeones, Integer pasos) {
        this.cazadoresAndLeones = cazadoresAndLeones;
        this.leonesCazados = new ArrayList<>();
        this.totalCazados = 0;
        this.pasos = pasos;
    }

    public void cazar(){
        for (int i = 0; i < cazadoresAndLeones.size() -1; i++) {
            if (cazadoresAndLeones.get(i) == true){
                boolean cazo = false;
                for (int j = i+1; j <= i + this.pasos; j++) {
                    if (j < cazadoresAndLeones.size() && cazadoresAndLeones.get(j) == false){
                        if (cazo == false){
                            if (!leonesCazados.contains(j)){
                                leonesCazados.add(j);
                                totalCazados++;
                            }
                            cazo = true;
                        }
                    }
                }
            }
        }
        System.out.println(totalCazados);
    }
}
