package espe.publicaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import espe.publicaciones.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
