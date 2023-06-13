package Greedy.Ej2;

public class ObjetoFraccionario {

    private String nombre;
    private Double peso;
    private Double valor;

    public ObjetoFraccionario(Double peso, Double valor, String nombre) {
        this.peso = peso;
        this.valor = valor;
        this.nombre = nombre;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
