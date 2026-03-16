package EjercicioPersonajes.org.example;

import java.io.File;
import java.io.RandomAccessFile;

public class ManejoFicheros {


    static final int TAMANO = 16;

    public static void escribeRafTomates(File file, int tipoUnidad, int dañoRealizado, int defensa, int curacion){
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

    public static String leeArchivoDirecto(File file){
        StringBuilder sb = new StringBuilder();
        try(RandomAccessFile raf = new RandomAccessFile(file, "r")){
            while(raf.getFilePointer() < raf.length()){
                for(int i=0; i<4;i++){
                    sb.append(raf.readInt()).append(" ");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
