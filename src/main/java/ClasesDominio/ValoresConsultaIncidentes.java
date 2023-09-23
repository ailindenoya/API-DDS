package ClasesDominio;

import java.time.LocalDate;

public class ValoresConsultaIncidentes {
  String nombreEntidad;
  EstadoIncidente estadoIncidente;
  LocalDate fechaApertura;
  LocalDate fechaCierre;

  public ValoresConsultaIncidentes(String nombreEntidad, EstadoIncidente estadoIncidente, LocalDate fechaApertura, LocalDate fechaCierre) {
    this.nombreEntidad = nombreEntidad;
    this.estadoIncidente = estadoIncidente;
    this.fechaApertura = fechaApertura;
    this.fechaCierre = fechaCierre;
  }

  public String getNombreEntidad() {
    return nombreEntidad;
  }

  public EstadoIncidente getEstadoIncidente() {
    return estadoIncidente;
  }

  public LocalDate getFechaApertura() {
    return fechaApertura;
  }

  public LocalDate getFechaCierre() {
    return fechaCierre;
  }

  public void setNombreEntidad(String nombreEntidad) {
    this.nombreEntidad = nombreEntidad;
  }

  public void setEstadoIncidente(EstadoIncidente estadoIncidente) {
    this.estadoIncidente = estadoIncidente;
  }

  public void setFechaApertura(LocalDate fechaApertura) {
    this.fechaApertura = fechaApertura;
  }

  public void setFechaCierre(LocalDate fechaCierre) {
    this.fechaCierre = fechaCierre;
  }
}
