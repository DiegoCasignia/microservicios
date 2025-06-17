package espe.publicaciones.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import espe.publicaciones.model.Paper;

public interface PaperRepository extends JpaRepository<Paper, Long> {

}
