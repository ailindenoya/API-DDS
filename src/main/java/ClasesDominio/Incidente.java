package ClasesDominio;

import java.time.LocalDate;

public class Incidente {
  public String nombre;

  public LocalDate fechaApertura;

  public LocalDate fechaCierre;

  public Servicio servicioAfectado;

  public String descripcion;

  public EstadoIncidente estado;

  public Incidente(String nombre, LocalDate fechaApertura, LocalDate fechaCierre, Servicio servicioAfectado, String descripcion, EstadoIncidente estado) {
    this.nombre = nombre;
    this.fechaApertura = fechaApertura;
    this.fechaCierre = fechaCierre;
    this.servicioAfectado = servicioAfectado;
    this.descripcion = descripcion;
    this.estado = estado;
  }

  public String getNombre() {
    return nombre;
  }

  public LocalDate getFechaApertura() {
    return fechaApertura;
  }

  public LocalDate getFechaCierre() {
    return fechaCierre;
  }

  public Servicio getServicioAfectado() {
    return servicioAfectado;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public EstadoIncidente getEstado() {
    return estado;
  }

}
