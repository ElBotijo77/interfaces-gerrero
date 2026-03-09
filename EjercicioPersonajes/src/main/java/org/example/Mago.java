package org.example;

    public class Mago extends Personaje implements Atacante{

        int ataque = 0;

        // Constructor
        public Mago(int vida, int tipo, int nivel) {
            super(vida, tipo, nivel);
        }

        @Override
        public void turno(Object personaje) {
            ataque = atacar();
            IO.println("El mago ha hecho " + ataque + " puntos de daño");
        }

        // Metodos
        @Override
        public int atacar() {
            return Combate.aleatorio(20);
        }

        public int ataqueEnemigo(){
            return ataque;
        }
    }
