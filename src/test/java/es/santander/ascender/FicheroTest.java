package es.santander.ascender;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FicheroTest {
    private Fichero cut;

    @BeforeAll
    public static void setUpAll() {
        System.out.println("Paso por el Before All");
    }

    @BeforeEach
    public  void setUp() {
        System.out.println("Paso por el Before Each");
        //cut = new FicheroParaTesting();
        Fichero noHagoNadaConEsteEsInterna = new FicheroParaTesting2();

        Fichero noHagoNadaConEstaTampoYNoTieneNiNombre = new Fichero() {

            @Override
            public void hacerElLunes() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'hacerElLunes'");
            }
            
        };
    }


    @Test
    void testEscribir() throws IOException {
        // Preparaba

        System.out.println("Test1");
        File ficheroTemporalACrear =  File.createTempFile("hola", ".juan");
        String ruta = ficheroTemporalACrear.getAbsolutePath();
        ficheroTemporalACrear.delete();


        byte[] datosAEscribir = new byte[5478];

        // Ejecutaba

        assertFalse(ficheroTemporalACrear.exists(), "El fichero existe");

        cut.escribir(ruta, datosAEscribir);


        // Verificaba
        assertTrue(ficheroTemporalACrear.exists(), "El fichero no existe");
    
        assertEquals(5478, ficheroTemporalACrear.length(), "No coincide el tamaño");
    }

    @Test
    void testLeerEnBloques() throws IOException {
        byte[] leido = cut.leerEnBloques("./src/test/resources/juan.txt");
        assertArrayEquals("adios".getBytes(), leido);
    }

    @Test
    void testEncoding() {
        String cadena = "Holáñ";
        
        byte[] bytes1 = cadena.getBytes(Charset.forName("UTF-8"));
        byte[] bytes2 = cadena.getBytes(Charset.forName("ISO-8859-1"));

        for (int i =  0 ; i < bytes1.length; i++) {
            if (bytes1[i] != bytes2[i]) {
                return;
            }
        }
        fail("No he encontrado diferencias");
    }


    public class FicheroParaTesting2 extends Fichero {

        @Override
        public void hacerElLunes() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'hacerElLunes'");
        }
        
    }
}
