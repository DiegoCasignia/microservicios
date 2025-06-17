package espe.publicaciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import espe.publicaciones.dto.LibroDto;
import espe.publicaciones.dto.ResponseDto;
import espe.publicaciones.model.Autor;
import espe.publicaciones.model.Libro;
import espe.publicaciones.repository.AutorRepository;
import espe.publicaciones.repository.LibroRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private NotificacionProducer producer;

    public ResponseDto crearLibro(LibroDto dto) {
        Autor autor = autorRepository.findById(dto.getIdAutor())
                .orElseThrow(() -> new RuntimeException("No existe el autor con id: " + dto.getIdAutor()));

        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setAnioPublicacion(dto.getAnioPublicacion());
        libro.setResumen(dto.getResumen());
        libro.setEditorial(dto.getEditorial());
        libro.setIsbn(dto.getIsbn());
        libro.setGenero(dto.getGenero());
        libro.setNumeroPaginas(dto.getNumeroPaginas());
        libro.setAutor(autor);

        Libro saved = libroRepository.save(libro);
        producer.enviarNotificacion("Libro: " + saved.getTitulo() + "ha sido creado", "Libro");

        return new ResponseDto("Libro registrado exitosamente", libroRepository.save(libro));
    }

    public List<ResponseDto> listarLibros() {
        return libroRepository.findAll().stream()
                .map(libro -> new ResponseDto("Libro: " + libro.getTitulo(), libro))
                .collect(Collectors.toList());
    }

    public ResponseDto libroPorId(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el libro con id: " + id));
        return new ResponseDto("Libro con id " + libro.getId(), libro);
    }

    public ResponseDto actualizarLibro(Long id, LibroDto dto) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el libro con id: " + id));

        Autor autor = autorRepository.findById(dto.getIdAutor())
                .orElseThrow(() -> new RuntimeException("No existe el autor con id: " + dto.getIdAutor()));

        libro.setTitulo(dto.getTitulo());
        libro.setAnioPublicacion(dto.getAnioPublicacion());
        libro.setResumen(dto.getResumen());
        libro.setEditorial(dto.getEditorial());
        libro.setIsbn(dto.getIsbn());
        libro.setGenero(dto.getGenero());
        libro.setNumeroPaginas(dto.getNumeroPaginas());
        libro.setAutor(autor);

        return new ResponseDto("Libro actualizado exitosamente", libroRepository.save(libro));
    }

    public ResponseDto eliminarLibro(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el libro con id: " + id));
        libroRepository.delete(libro);
        return new ResponseDto("Libro eliminado exitosamente con id: " + id, null);
    }
}
