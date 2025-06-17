package espe.publicaciones.dto;

public class ResponseDto {
    private String mensaje;
    private Object dato;

    public ResponseDto(String mensaje, Object dato) {
        this.mensaje = mensaje;
        this.dato = dato;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }
}
