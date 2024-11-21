package es.santander.ascender;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FicheroAntiguoTest {

    @Test
    public void testLeerFichero() throws IOException {

        FicheroAntiguo fa = new FicheroAntiguo();

        // Crear un archivo temporal
        Path tempFile = Files.createTempFile("test", ".txt");

        // Imprimir la ruta del archivo temporal creado
        System.out.println("Archivo temporal creado en: " + tempFile.toString());

        // Escribir contenido en el archivo temporal
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile, StandardCharsets.UTF_8)) {
            writer.write("Primera línea");
            writer.newLine();
            writer.write("Segunda línea");
            writer.newLine();
            writer.write("Tercera línea");
        }

        // Llamar al método leerFichero() usando el archivo temporal
        List<String> lineasLeidas = fa.leerFichero(tempFile.toString());

        // Verificar que las líneas leídas son las esperadas
        assertNotNull(lineasLeidas);
        assertEquals(3, lineasLeidas.size()); // Verificar que haya 3 líneas
        assertEquals("Primera línea", lineasLeidas.get(0)); // Verificar la primera línea
        assertEquals("Segunda línea", lineasLeidas.get(1)); // Verificar la segunda línea
        assertEquals("Tercera línea", lineasLeidas.get(2)); // Verificar la tercera línea

        // Limpiar el archivo temporal después de la prueba
        Files.delete(tempFile);
    }
}
