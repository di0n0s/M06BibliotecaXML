/*
 * Ejemplo con sistema gestor XML nativo (eXist)
 */
package bibliotecaxml;

import java.util.List;
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
            Autor a = new Autor("Michael Ende", "EEUU");
            Libro l = new Libro("La Historia Interminable", a, 500);
            gestor.insertarLibro(l);
            System.out.println("Libro insertado");
            List<Libro> libros = gestor.selectAllLibros();
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | XMLDBException ex) {
            System.out.println("Error con la BBDD: " + ex.getMessage());
        }
    }

}
