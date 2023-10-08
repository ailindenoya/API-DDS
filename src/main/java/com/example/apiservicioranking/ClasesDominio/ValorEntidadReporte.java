package com.example.apiservicioranking.ClasesDominio;

public class ValorEntidadReporte implements Comparable<ValorEntidadReporte> {
  private int id;
  private double valor;


  public ValorEntidadReporte(int id, double valor) {
    this.id = id;
    this.valor = valor;
  }

  public int getId() {
    return id;
  }

  public double getValor() {
    return valor;
  }

  public void setId(int id) {
    this.id= id;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  @Override
  public int compareTo(ValorEntidadReporte valor1) {
    return Double.compare(valor1.getValor(),this.getValor());
  }
}
