package com.example.apiservicioranking.ClasesDominio;

public enum EstadoIncidente {
  ABIERTO,
  CERRADO;

  private static EstadoIncidente[] values = null;
  public static EstadoIncidente fromInt(int i) {
    if(EstadoIncidente.values == null) {
      EstadoIncidente.values = EstadoIncidente.values();
    }
    return EstadoIncidente.values[i];
  }
}
