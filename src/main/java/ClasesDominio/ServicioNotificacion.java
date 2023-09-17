package ClasesDominio;

public class ServicioNotificacion {
  String tipo;
  String id;

  public ServicioNotificacion(String tipo, String id) {
    this.tipo = tipo;
    this.id = id;
  }

  public String getTipo() {
    return tipo;
  }

  public String getId() {
    return id;
  }
}
