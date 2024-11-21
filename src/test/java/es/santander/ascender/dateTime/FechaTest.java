package es.santander.ascender.dateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class FechaTest {
    
    @Test
    public void encontrarMayorFechaTest() {

        Fecha fecha = new Fecha();
        String ingreso = "2024, 12, 53, 31";

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese una fecha en formato yyyy-MM-dd
        System.out.print("Ingrese una fecha (formato yyyy-MM-dd): ");
        String fechaInput = scanner.nextLine();
        
        String resultado = fecha.encontrarMayorFecha(fechaInput);

        assertNotNull(resultado);
     
        assertEquals(ingreso, resultado);

        scanner.close();
    }
}
