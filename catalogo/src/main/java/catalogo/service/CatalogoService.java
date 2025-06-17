package catalogo.service;

import catalogo.dto.CatalogoDto;
import catalogo.entity.Catalogo;
import catalogo.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CatalogoService {
    @Autowired
    private CatalogoRepository repository;

    public List<Catalogo> listarTodas(){
        return repository.findAll();
    }

    public void guardar(CatalogoDto dto){
        Catalogo catalogo = new Catalogo();
        catalogo.setMensaje(dto.getMensaje());
        catalogo.setTipo(dto.getTipo());
        catalogo.setFecha(LocalDateTime.now());
        repository.save(catalogo);
    }
}
