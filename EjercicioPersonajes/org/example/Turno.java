package EjercicioPersonajes.org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static EjercicioPersonajes.org.example.ManejoFicheros.devuelveListaTrasLeer;

public class Turno {

    /* SI DA TIEMPO SE AÑADIRÁN ACCIONES PARA ENEMIGO, POR EL MOMENTO NO HARA NADA
       Los tipos corresponden a estas clases
     * Tipo 0: Guerrero
     * Tipo 1: Mago
     * Tipo 2: Clerigo
     * */
    
    static File ficheroDatos = new File("datosGuardados.bin");
    static int contadorTurno = 0;
    
    //Cada vez que se llame al turno generaTurno, se crearan unos ataques/defensa/curacion aleatorios y serán
    //guardados dentro de un fichero para su posterior lectura
    public static void generaTurno(Guerrero guerrero, Mago mago, Clerigo clerigo){
        ArrayList<Integer> datosTurno;

        //Metodo que genera el turno y lo escirbe en el archivo
        generaAtaquesDefensasCuracion(guerrero, mago, clerigo);

        //En esta lista objetenemos los valores de la batalla a sucio
        datosTurno = devuelveListaTrasLeer("datosGuardados.bin", contadorTurno);

        //Devolvemos por pantalla los datos obtenidos
        traducirDatosHumano(datosTurno);

        //Contador para saber en que posicion poner el SEEK
        contadorTurno++;
    }

    
    //Metodo que genera los ataques y escribe en un archivo binario
    public static void generaAtaquesDefensasCuracion(Guerrero guerrero, Mago mago, Clerigo clerigo){
        //Comprobacion de los supervivientes con un metodo aparte. Si no esta vivo, escibira 0
        boolean[] supervivientes = devuleveSupervivientes(guerrero, mago, clerigo);

        //Escritura del ataque, defensa o curacion que ha generado.
        //Guerrero (Tipo 0)
        ManejoFicheros.escribeBinario(ficheroDatos, 0,
                supervivientes[0] ? guerrero.atacar() : 0,
                supervivientes[0] ? guerrero.defender() : 0, 0);

        //Mago (Tipo 1)
        ManejoFicheros.escribeBinario(ficheroDatos, 1,
                supervivientes[1] ? mago.atacar() : 0, 0, 0);

        //Clerigo (Tipo 2)
        ManejoFicheros.escribeBinario(ficheroDatos, 2, 0,
                supervivientes[2] ? clerigo.defender() : 0,
                supervivientes[2] ? clerigo.curacion : 0);
    }

    
    //Metodo que devuelve un array boleano en el que mostrará 1 si el personaje esta vivo, o 0 si no lo está.
    public static boolean[] devuleveSupervivientes(Guerrero g, Mago m, Clerigo c){
        boolean[] bool = new boolean[3];
        bool[0] = g.getVida() > 0;
        bool[1] = m.getVida() > 0;
        bool[2] = c.getVida() > 0;
        return bool;
    }


    //Traduce a idioma humano los datos recogidos del archivo
    public static void traducirDatosHumano(ArrayList<Integer> datos) {
        if (datos.isEmpty()) {
            System.out.println("No hay datos para mostrar en este turno.");
            return;
        }

        for (int i = 0; i < datos.size(); i += 4) {
            int tipo = datos.get(i);
            int ataque = datos.get(i + 1);
            int defensa = datos.get(i + 2);
            int curacion = datos.get(i + 3);

            // Si todos los valores son 0, es que el personaje estaba muerto
            if (ataque == 0 && defensa == 0 && curacion == 0) continue;

            switch (tipo) {
                case 0 -> System.out.println("El Guerrero ha atacado " + ataque + " puntos y ha defendido " + defensa + ".");
                case 1 -> System.out.println("El Mago ha lanzado un hechizo de " + ataque + " puntos de daño.");
                case 2 -> System.out.println("El Clérigo ha protegido con " + defensa + " de defensa y curado " + curacion + " puntos.");
            }
        }
    }
}
