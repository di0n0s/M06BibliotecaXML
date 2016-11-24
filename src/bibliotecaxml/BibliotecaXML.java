/*
 * Ejemplo con sistema gestor XML nativo (eXist)
 */
package bibliotecaxml;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmldb.api.base.XMLDBException;

/**
 *
 * @author mfontana
 */
public class BibliotecaXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Creamos el gestor y "establecemos conexión"
            BibliotecaXND gestor = new BibliotecaXND();
            System.out.println("Conexión establecida.");
            Autor a = new Autor("Stephen King", "EEUU");
            Libro l = new Libro("It", a, 300);
            gestor.insertarLibro(l);
            System.out.println("Libro insertado");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | XMLDBException ex) {
            System.out.println("Error con la BBDD: " + ex.getMessage());
        }
    }

}
