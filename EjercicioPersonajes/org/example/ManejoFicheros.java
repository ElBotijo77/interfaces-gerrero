package EjercicioPersonajes.org.example;

import java.io.EOFException;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ManejoFicheros {

    static final int TAMANO = 16;

    //Escribe lo que ha hecho cada unidad, como daño realizado o curacion. El tipo de unidad se guarda para
    //mostrar despues por pantalla unos datos mas amigables
    public static void escribeBinario(File file, int tipoUnidad, int dañoRealizado, int defensa, int curacion){
        try(RandomAccessFile raf = new RandomAccessFile(file, "rw")){

            raf.seek(raf.length());

            //Escribrimos en el archivo
            raf.writeInt(tipoUnidad);
            raf.writeInt(dañoRealizado);
            raf.writeInt(defensa);
            raf.writeInt(curacion);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Devuelve un lista para su posterior uso, leyendo siempre desde la posicion dada para
    //obtener unos datos mas limpios
    public static ArrayList<Integer> devuelveListaTrasLeer(String fichero, int position){
        ArrayList<Integer> datos = new ArrayList<>();
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            // Multiplicar por 3 debido al numero total de registros, que son 3 personajes
            long offset = (long) 16 * position * 3;

            if (offset < raf.length()) {
                raf.seek(offset);
                // Leemos los 4 ints del registro (16 bytes)
                for (int i = 0; i < 12; i++) {
                    datos.add(raf.readInt());
                }
            }
        } catch (EOFException e){
            IO.println("Listo");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return datos;
    }
}
