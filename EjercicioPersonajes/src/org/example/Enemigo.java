package org.example;

public class Enemigo extends Personaje implements Atacante, Defensor, Curador{


    public Enemigo(int vida, int tipo, int nivel) {
        super(vida, tipo, nivel);
    }


    @Override
    public int atacar() {
        return Combate.aleatorio(15);
    }

    @Override
    public int curar() {
        return 0;
    }

    @Override
    public int defender() {
        return 0;
    }

    @Override
    public void turno(Object personaje) {

    }

    @Override
    public void actualizaVida() {

    }
}
