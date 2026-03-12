package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        /*Los tipos correstponden a estas clases
        * Tipo 0: Guerrero
        * Tipo 1: Mago
        * Tipo 2: Clerigo
        * */

        Guerrero g = new Guerrero(50, 0, 2);
        Mago m = new Mago(50, 1, 10);
        Clerigo c = new Clerigo(50, 2, 7);
        Enemigo n = new Enemigo(100, -1, 0);

    }
}
