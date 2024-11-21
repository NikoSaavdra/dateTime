package es.santander.ascender.dateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fecha {

    public String encontrarMayorFecha(String fechaIngresada) {

          // Variable para almacenar los resultados en formato de cadena
          StringBuilder listaMaximo = new StringBuilder();

        // Crear un objeto SimpleDateFormat para convertir la cadena de texto a una
        // fecha
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Convertir la cadena ingresada en un objeto Date
            Date fecha = formato.parse(fechaIngresada);

            // Crear un objeto Calendar y establecer la fecha
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fecha);

            // Obtener los valores máximos para los diferentes campos
            int maxAño = calendario.getActualMaximum(Calendar.YEAR);
            int maxMes = calendario.getActualMaximum(Calendar.MONTH); // Los meses son 0-indexados (0 para enero, 11  para diciembre)
            int maxSemana = calendario.getActualMaximum(Calendar.WEEK_OF_YEAR);
            int maxDia = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);

            // Concatenar los valores máximos en la cadena, separados por comas
            listaMaximo.append(maxAño).append(", ");
            listaMaximo.append(maxMes + 1).append(", "); // Sumamos 1 para mostrar el mes en el rango 1-12
            listaMaximo.append(maxSemana).append(", ");
            listaMaximo.append(maxDia);
        } catch (Exception e) {
            // Si la fecha ingresada no tiene el formato correcto
            System.out.println("Formato de fecha inválido. Por favor ingrese la fecha en formato yyyy-MM-dd.");
        }

        // Retornar la cadena con los valores máximos
        return listaMaximo.toString();
    }
}
