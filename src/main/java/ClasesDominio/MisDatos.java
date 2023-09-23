package ClasesDominio;

import java.util.List;

public class MisDatos {

  private String nombre;

  private List<ValorEntidadReporte> entidades;

  public MisDatos(String nombre, List<ValorEntidadReporte> entidades) {
    this.nombre = nombre;
    this.entidades = entidades;
  }

  public String getNombre() {
    return nombre;
  }

  public List<ValorEntidadReporte> getEntidades() {
    return entidades;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setEntidades(List<ValorEntidadReporte> entidades) {
    this.entidades = entidades;
  }
}
