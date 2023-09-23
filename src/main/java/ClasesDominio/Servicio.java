package ClasesDominio;

import java.util.List;

public class Servicio {

  String descripcion;
  Entidad entidad;
  List<Incidente> incidentes;

  public Servicio(String descripcion, Entidad entidad,List<Incidente> incidentes) {
    this.descripcion = descripcion;
    this.entidad = entidad;
    this.incidentes = incidentes;
  }

  public void setDescripcion(String descripcionN){
    descripcion = descripcionN;
  }
  public String getDescripcion() {
    return descripcion;
  }

}
