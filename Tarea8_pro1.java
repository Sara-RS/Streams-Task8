package tarea8_pro1;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class Tarea8_pro1 {

    public static void main(String[] args) {
        
        if (args.length < 2) {
            System.out.println("Ingrese dos argumentos: ");
            System.out.println("Ingrese la ruta del archivo y la ruta del folder como argumentos.");
            return;
        }

        String rutaArchivo = args[0];
        String rutaFolder = args[1];

        File archivoOriginal = new File(rutaArchivo);

        if (!archivoOriginal.exists()) {
            System.out.println("El archivo especificado no existe: " + rutaArchivo);
            return;
        }

        String nombreArchivo = archivoOriginal.getName();
        File archivoCopia = new File(rutaFolder, nombreArchivo);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal));
             FileWriter writer = new FileWriter(archivoCopia)) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea.toUpperCase() + System.lineSeparator());
            }
            System.out.println("Copia creada correctamente en: " + archivoCopia.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo.");
            e.printStackTrace();
        }
    }
}
