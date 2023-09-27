package com.example.apiservicioranking.ClasesDominio;

public class ValorEntidadReporte implements Comparable<ValorEntidadReporte> {
  private String nombre;
  private double valor;


  public ValorEntidadReporte(String nombre, double valor) {
    this.nombre = nombre;
    this.valor = valor;
  }

  public String getNombre() {
    return nombre;
  }

  public double getValor() {
    return valor;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  @Override
  public int compareTo(ValorEntidadReporte valor1) {
    return Double.compare(valor1.getValor(),this.getValor());
  }
}
