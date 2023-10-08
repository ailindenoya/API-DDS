package com.example.apiservicioranking.ClasesDominio;

import java.util.List;

public class Entidad {

  int id;
  List<Servicio> servicios;


  public Entidad(int id, List<Servicio> servicios) {
    this.id = id;
    this.servicios = servicios;
  }

}
