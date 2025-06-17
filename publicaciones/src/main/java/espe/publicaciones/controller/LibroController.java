package espe.publicaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import espe.publicaciones.dto.LibroDto;
import espe.publicaciones.dto.ResponseDto;
import espe.publicaciones.service.LibroService;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping
    public ResponseDto crearLibro(@RequestBody LibroDto dto) {
        return libroService.crearLibro(dto);
    }

    @GetMapping
    public List<ResponseDto> obtenerLibros() {
        return libroService.listarLibros();
    }

    @GetMapping("/{id}")
    public ResponseDto buscarLibroPorId(@PathVariable Long id) {
        return libroService.libroPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseDto actualizarLibro(@PathVariable Long id, @RequestBody LibroDto dto) {
        return libroService.actualizarLibro(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto eliminarLibro(@PathVariable Long id) {
        return libroService.eliminarLibro(id);
    }
}
