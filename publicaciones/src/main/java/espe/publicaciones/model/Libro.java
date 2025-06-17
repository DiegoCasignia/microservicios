package espe.publicaciones.model;

import jakarta.persistence.*;

@Entity
public class Libro extends Publicacion {
    private String genero;
    private int numeroPaginas;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
