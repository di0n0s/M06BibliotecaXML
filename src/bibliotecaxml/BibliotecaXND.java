/*
 * Clase que accede a la bbdd
 */
package bibliotecaxml;

import javax.xml.transform.OutputKeys;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.CompiledExpression;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XQueryService;

/**
 *
 * @author mfontana
 */
public class BibliotecaXND {
    private Database database;
    private final String uri = "xmldb:exist://localhost:8080/exist/xmlrpc";
    private final String user = "admin";
    private final String pass = "admin";
    private final String colecLibros = "/db/biblioteca/libros";
    private final String colecAutores = "/db/biblioteca/autores";

    public BibliotecaXND() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        String driver = "org.exist.xmldb.DatabaseImpl";
        Class c1;
        c1 = Class.forName(driver);
        database = (Database) c1.newInstance();
        DatabaseManager.registerDatabase(database);
    }
    
    
    public void insertarLibro(Libro miLibro) throws XMLDBException {
        String consulta = "update insert <Libro> <Titulo>"+miLibro.getTitulo()+"</Titulo>"
                + "<Autor>"+miLibro.getAutor().getNombre()+"</Autor>"
                + "<Npags>"+miLibro.getNpags()+"</Npags></Libro> into /Libros";
        ejecutarConsultaUpdate(colecLibros, consulta);
    }
    
    
    // Función interna para ejecutar consultas de tipo update
    private void ejecutarConsultaUpdate(String coleccion, String consulta) throws XMLDBException {
        Collection col = DatabaseManager.getCollection(uri+coleccion, user, pass);
        XQueryService servicio = (XQueryService) col.getService("XQueryService", "1.0");
        servicio.setProperty(OutputKeys.INDENT, "yes");
        servicio.setProperty(OutputKeys.ENCODING, "UTF-8");
        CompiledExpression consultaCompilada = servicio.compile(consulta);
        servicio.execute(consultaCompilada);
    }
    
    
}
