package EjercicioPersonajes.org.example;

import java.util.Scanner;

public class Main {
    static void main() {

        /*Los tipos corresponden a estas clases
        * Tipo 0: Guerrero
        * Tipo 1: Mago
        * Tipo 2: Clerigo
        * */

        /*Se crean varias clases de personajes con las caracteristicas pedidas y una clase Enenimgo que por
        * el momento no realizará ninguna accion. Las acciones de los personajes son dadas de forma aleatoria
        * y se guardan en un archivo binario para poder guardar los datos de cada ronda y poder consultarla
        * en cualquier momento gracias a seek(). La logica general del programa esta recogida en la clase Turno
        * que sera la que aplica los daños, etc, los lee y escribe al archivo binario y muestra por pantalla
        * los datos recopilados en un array (Siempre tiene el mimso formato, dividido en registros de 4 datos
        * cada uno). Finalmente cuando el enemigo muere, el programa finaliza*/

        //Declaracion de personajes
        Guerrero g = new Guerrero(50, 0, 2);
        Mago m = new Mago(50, 1, 10);
        Clerigo c = new Clerigo(50, 2, 7);
        Enemigo n = new Enemigo(100, -1, 0);

        //Definicion de cada ronda, en la que elegiremos si huir o luchar un turno mas
        Scanner sc = new Scanner(System.in);
        boolean huir = false;

        //Elegimos entre huir o continuar en el ataque hasta que el enemigo haya MUERTO.
        while (!huir) {
            huir = Turno.generaTurno(g, m, c, n);
            if (huir) break;

            System.out.println("¿Quieres huir? (0: Continuar / 1: Huir)");
            huir = (sc.nextInt() == 1);
        }
        IO.println("Programa finalizado con exito");
        sc.close();
    }
}
