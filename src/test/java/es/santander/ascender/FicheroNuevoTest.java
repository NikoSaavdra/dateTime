package es.santander.ascender;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FicheroNuevoTest {

    @Test
    public void leerYEscribirArchivoTest() throws IOException {
        FicheroNuevo fn = new FicheroNuevo();

        // Crear un archivo temporal de entrada (donde vamos a leer)
        Path tempFileIn = Files.createTempFile("inputTest", ".txt");

        // Crear un archivo temporal de salida (donde vamos a escribir)
        Path tempFileOut = Files.createTempFile("outputTest", ".txt");

        // Escribir contenido en el archivo de entrada
        try (BufferedWriter writer = Files.newBufferedWriter(tempFileIn, StandardCharsets.UTF_8)) {
            writer.write("Primera línea");
            writer.newLine();
            writer.write("Segunda línea");
            writer.newLine();
            writer.write("Tercera línea");
        }

        // Leer las líneas del archivo de entrada y escribirlas en el archivo de salida
        List<String> lines = fn.leerFicheroNuevo(tempFileIn.toString());
        fn.escribirEnFicheroNuevo(tempFileOut.toString(), lines);

        // Leer el archivo de salida y verificar su contenido
        List<String> linesReadFromOut = fn.leerFicheroNuevo(tempFileOut.toString());

        // Verificar que las líneas leídas del archivo de salida sean las esperadas
        assertNotNull(linesReadFromOut);
        assertEquals(3, linesReadFromOut.size()); // Verificar que haya 3 líneas
        assertEquals("Primera línea", linesReadFromOut.get(0)); // Verificar la primera línea
        assertEquals("Segunda línea", linesReadFromOut.get(1)); // Verificar la segunda línea
        assertEquals("Tercera línea", linesReadFromOut.get(2)); // Verificar la tercera línea

        // Limpiar los archivos temporales después de la prueba
        Files.delete(tempFileIn);
        Files.delete(tempFileOut);
    }
}
