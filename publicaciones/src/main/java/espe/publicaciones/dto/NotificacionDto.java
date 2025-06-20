package espe.publicaciones.dto;

public class NotificacionDto {
    private String mensaje;
    private String tipo;

    public NotificacionDto(String mensaje, String tipo) {
        this.mensaje = mensaje;
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}