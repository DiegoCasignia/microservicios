package espe.notificaciones.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import espe.notificaciones.dto.NotificacionDto;
import espe.notificaciones.service.NotificacionService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificacionesListener {

    @Autowired
    private NotificacionService service;

    @Autowired
    private ObjectMapper mapper;

    @RabbitListener(queues = "notificaciones.cola")
    public void recibirMensajes(String mensaje){
        try{
            NotificacionDto dto = mapper.readValue(mensaje, NotificacionDto.class);
            service.guardar(dto);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
