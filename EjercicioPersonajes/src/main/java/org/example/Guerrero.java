package org.example;

public class Guerrero extends Personaje implements Atacante, Defensor{

    public Guerrero(int vida, int tipo, int nivel) {
        super(vida, tipo, nivel);
    }

    @Override
    public int atacar() {
        return Combate.aleatorio(15);
    }

    @Override
    public int defender() {
        return Combate.aleatorio(8);
    }
}
