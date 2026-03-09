package org.example;

public class Clerigo extends Personaje implements Curador, Defensor {

    int defender = 0;
    int curacion = 0;

    // Constructor
    public Clerigo(int vida, int tipo, int nivel) {
        super(vida, tipo, nivel);
    }

    @Override
    public void turno(Object personaje) {
        defender = defender();
        curacion = curar();
        IO.println("El clerigo ha curado " + curacion + ", y defendido en " + defender);
    }

    // Metodos
    @Override
    public int curar() {
        return Combate.aleatorio(18);
    }


    @Override
    public int defender() {
        return Combate.aleatorio(3);
    }
}
