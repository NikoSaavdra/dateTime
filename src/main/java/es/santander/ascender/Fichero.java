package es.santander.ascender;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class Fichero implements Closeable {

        // valor = 1;
        // int a, b, c;
        // a = b = c = 3;

    public byte[] leer(String nombreFichero) throws IOException {
        int valor;

        byte[] resultado;
        
        try (FileInputStream fis = new FileInputStream(nombreFichero); 
            ByteArrayOutputStream baos = new ByteArrayOutputStream();) 
        {
            while ((valor = fis.read()) != -1) {
                baos.write(valor);
            }
            resultado = baos.toByteArray();
        } 
        return resultado;
    }

    public byte[] leerEnBloques(String nombreFichero) throws IOException {
        int cuantos;
        byte[] valores = new byte[4096];

        byte[] resultado;

        try (FileInputStream fis = new FileInputStream(nombreFichero); 
            ByteArrayOutputStream baos = new ByteArrayOutputStream();) 
        {
            while ((cuantos = fis.read(valores)) != -1) {
                baos.write(valores, 0, cuantos);
            }
            resultado = baos.toByteArray();
        }

        return resultado;
    }

    public void escribir(String nombreFichero, byte[] datos) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(nombreFichero);) {
            fos.write(datos);
        }
    }

    @Override
    public void close() throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }

    public abstract void hacerElLunes();
}