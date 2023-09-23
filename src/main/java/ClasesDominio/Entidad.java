package ClasesDominio;

import java.util.List;

public class Entidad {

  String nombre;
  List<Servicio> servicios;

  public Entidad(String nombre, List<Servicio> servicios) {
    this.nombre = nombre;
    this.servicios = servicios;
  }

}
