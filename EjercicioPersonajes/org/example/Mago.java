package EjercicioPersonajes.org.example;

    public class Mago extends Personaje implements Atacante{

        private int ataqueMago = 0;

        // Constructor
        public Mago(int vida, int tipo, int nivel) {
            super(vida, tipo, nivel);
        }


        // Implementacion de los metodos abstractos
        @Override
        public void turno(Object personaje) {
            ataqueMago = atacar();
            IO.println("El mago ha hecho " + ataqueMago + " puntos de daño");
        }

        @Override
        public void actualizaVida() {

        }

        // Metodos
        @Override
        public int atacar() {
            return Combate.aleatorio(20);
        }

        public int ataqueEnemigo(){
            return ataqueMago;
        }


        //Guetter y setter para ataque
        public int getAtaqueMago() {
            return ataqueMago;
        }

        public void setAtaqueMago(int ataqueMago) {
            this.ataqueMago = ataqueMago;
        }
    }
