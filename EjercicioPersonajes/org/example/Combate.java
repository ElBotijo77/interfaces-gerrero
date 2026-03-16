package EjercicioPersonajes.org.example;

import java.util.Random;

// Genera un numero aleatorio entre 1 y n
public class Combate {
    public static int aleatorio(int n){
        Random random = new Random();
        int numero = random.nextInt(n) + 1;
        return numero;
    }

    
}
