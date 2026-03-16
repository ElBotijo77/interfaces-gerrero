package EjercicioPersonajes.org.example;

import java.util.Scanner;

public class Main {
    static void main() {

        /*Los tipos corresponden a estas clases
        * Tipo 0: Guerrero
        * Tipo 1: Mago
        * Tipo 2: Clerigo
        * */

        /*  Vamos a crear la clase turno, en el que manejara los ataques de cada UNIDAD. Para ello debemos cambiar
            a static todos los metodos de GUERRERO, CLERIGO y MAGO.
            En la clase TURNO manejaremos GUERRERO por ejemplo, llamando a los metodos ATACAR y DEFENDER. Hacer en todas las unidades
            Guardaremos esos datos en un FICHERO creado para la ocasion y al final del metodo que recoja todos los
            turnos de las UNIDADES guardará en una variable ATAQUE el ataque total, DEFENSA la defensa total, etc
            Esto se conseguira con el metodo LecturaFichero
            Al final eso se quitará a la clase ENEMIGO
            La defensa la podemos repartir entre todas las unidades del equipo, pero al final del turno deben volver
            a la vida actual. Toda la logica del porgrama la recogerá practicamente el metodo TURNO
            ------------------------------FIN--------------------------
        * */

        //Declaracion de personajes
        Guerrero g = new Guerrero(50, 0, 2);
        Mago m = new Mago(50, 1, 10);
        Clerigo c = new Clerigo(50, 2, 7);
        Enemigo n = new Enemigo(100, -1, 0);

        //Definicion de cada ronda, en la que elegiremos si huir o luchar un turno mas
        Scanner sc = new Scanner(System.in);
        boolean huir = false;

        while (!huir) {
            Turno.generaTurno(g, m, c);

            System.out.println("¿Quieres huir? (0: Continuar / 1: Huir)");
            huir = (sc.nextInt() == 1);
        }
        IO.println("Programa finalizado con exito");
        sc.close();
    }
}
