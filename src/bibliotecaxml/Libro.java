/*
 * Entidad Libro
 */
package bibliotecaxml;

/**
 *
 * @author mfontana
 */
public class Libro {
    
    private String titulo;
    private Autor autor;
    private int npags;

    public Libro(String titulo, Autor autor, int npags) {
        this.titulo = titulo;
        this.autor = autor;
        this.npags = npags;
    }
    

    public int getNpags() {
        return npags;
    }

    public void setNpags(int npags) {
        this.npags = npags;
    }


    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
