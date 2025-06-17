package espe.publicaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import espe.publicaciones.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
