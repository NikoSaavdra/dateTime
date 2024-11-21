package es.santander.ascender;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FicheroNuevo {

    public List<String> leerFicheroNuevo(String path) {
        // Leer el archivo línea por línea usando Files.lines() y devolver las líneas como una lista
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines.collect(Collectors.toList()); // Devolver las líneas como lista
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Retornar null en caso de error
        }
    }

    public void escribirEnFicheroNuevo(String path, List<String> lines) throws IOException {
        // Escribir las líneas en el archivo
        Files.write(Paths.get(path), lines, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    }
}

