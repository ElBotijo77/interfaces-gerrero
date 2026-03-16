package EjercicioPersonajes.org.example;

public abstract class Personaje {

    private int vida;
    private int tipo;
    private int nivel;

    public Personaje(int vida, int tipo, int nivel) {
        this.vida = vida;
        this.tipo = tipo;
        this.nivel = nivel;

        calcularVida();
    }

    //Metodos abstractos para definir el turno y calcular la vida tras un ataque
    public abstract void turno(Object personaje);

    public abstract void actualizaVida();

    //Metodos varios
    public void calcularVida(){
        vida += nivel;
    }

    public void muestraDatos() {
        IO.println("El " + tipo + " tiene " + vida + " puntos de vida");
    }

    //GETTERS Y SETTERS
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
