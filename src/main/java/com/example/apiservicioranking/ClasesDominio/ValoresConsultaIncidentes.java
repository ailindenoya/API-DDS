package com.example.apiservicioranking.ClasesDominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValoresConsultaIncidentes {
  EstadoIncidente estadoIncidente;
  LocalDate fechaApertura;
  LocalDate fechaCierre;

  public ValoresConsultaIncidentes( EstadoIncidente estadoIncidente, LocalDate fechaApertura, LocalDate fechaCierre) {
    this.estadoIncidente = estadoIncidente;
    this.fechaApertura = fechaApertura;
    this.fechaCierre = fechaCierre;
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

  public void setEstadoIncidente(EstadoIncidente estadoIncidente) {
    this.estadoIncidente = estadoIncidente;
  }

  public void setFechaApertura(LocalDate fechaApertura) {
    this.fechaApertura = fechaApertura;
  }

  public void setFechaCierre(LocalDate fechaCierre) {
    this.fechaCierre = fechaCierre;
  }

  public Long getTiempoResolucion(){
    return ChronoUnit.DAYS.between(fechaApertura,fechaCierre);
  }
}
