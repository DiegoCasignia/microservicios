package catalogo.controller;

import catalogo.entity.Catalogo;
import catalogo.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
    @Autowired
    private CatalogoService service;

    @GetMapping
    public List<Catalogo> listarTodas(){
        return service.listarTodas();
    }
}
