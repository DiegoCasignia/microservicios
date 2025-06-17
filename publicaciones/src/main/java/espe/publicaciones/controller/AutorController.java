package espe.publicaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import espe.publicaciones.dto.AutorDto;
import espe.publicaciones.dto.ResponseDto;
import espe.publicaciones.service.AutorService;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseDto createAutor(@RequestBody AutorDto dto) {
        return autorService.crearAutor(dto);
    }

    @GetMapping
    public List<ResponseDto> obtenerAutores() {
        return autorService.listarAutores();
    }

    @GetMapping("/{id}")
    public ResponseDto buscarPorId(@PathVariable Long id){
        return autorService.autorPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseDto actualizarAutor(@PathVariable Long id, @RequestBody AutorDto dto){
        return autorService.actualizarAutor(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto eliminarAutor(@PathVariable Long id) {
        return autorService.eliminarAutor(id);
    }
}
