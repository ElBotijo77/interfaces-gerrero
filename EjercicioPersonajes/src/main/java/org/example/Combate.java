package org.example;

import java.util.Random;

public class Combate {
    public static int aleatorio(int n){
        Random random = new Random();
        int numero = random.nextInt(n) + 1; // Genera 0-9 y suma 1
        return numero;
    }
}
