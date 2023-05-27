package Backtracking.Ej2;

public class Casilla {
    private int valor;
    private boolean norte;
    private boolean este;
    private boolean sur;
    private boolean oeste;

    private boolean visitada;

    public Casilla(int valor, boolean norte, boolean este, boolean sur, boolean oeste) {
        this.valor = valor;
        this.norte = norte;
        this.este = este;
        this.sur = sur;
        this.oeste = oeste;
    }


    public boolean isVisitada() {
        return visitada;
    }

    public void setVisitada(boolean visitada) {
        this.visitada = visitada;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isNorte() {
        return norte;
    }

    public void setNorte(boolean norte) {
        this.norte = norte;
    }

    public boolean isEste() {
        return este;
    }

    public void setEste(boolean este) {
        this.este = este;
    }

    public boolean isSur() {
        return sur;
    }

    public void setSur(boolean sur) {
        this.sur = sur;
    }

    public boolean isOeste() {
        return oeste;
    }

    public void setOeste(boolean oeste) {
        this.oeste = oeste;
    }
}
