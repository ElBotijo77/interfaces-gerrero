package EjercicioPersonajes.org.example;

public class Guerrero extends Personaje implements Atacante, Defensor{

    private int ataqueGuerrero = 0;
    private int defensaGuerrero = 0;

    //Constructores
    public Guerrero(int vida, int tipo, int nivel) {
        super(vida, tipo, nivel);
    }

    public Guerrero(){};

    //Implementacion de los metodos abstractos
    @Override
    public void turno(Object personaje) {

    }

    @Override
    public void actualizaVida() {

    }

    //Metodo que devuelve un ataque de Guerrero
    @Override
    public int atacar() {
        return Combate.aleatorio(15);
    }

    // Genera un aleatorio entre 1 y 8 para definir los punts de defensa
    @Override
    public int defender() {
        return Combate.aleatorio(8);
    }

    // Guetters y setters para ataque y defensa
    public int getAtaqueGuerrero() {
        return ataqueGuerrero;
    }

    public void setAtaqueGuerrero(int ataqueGuerrero) {
        this.ataqueGuerrero = ataqueGuerrero;
    }

    public int getDefensaGuerrero() {
        return defensaGuerrero;
    }

    public void setDefensaGuerrero(int defensaGuerrero) {
        this.defensaGuerrero = defensaGuerrero;
    }
}
