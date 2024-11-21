package es.santander.ascender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FicheroAntiguo {

    public List<String> leerFichero(String path) throws IOException {

        List<String> lineasLeidas = new ArrayList<>();

        // Usamos FileReader y BufferedReader para leer línea por línea
        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {

            String linea;
            // Leer línea por línea
            while ((linea = br.readLine()) != null) {
                lineasLeidas.add(linea); // Agregar la línea a la lista
            }
        }
        
        return lineasLeidas; // Devolver la lista de líneas leídas
    }
}
