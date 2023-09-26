package com.example.apiservicioranking.ClasesDominio;

public class ValoresConsultaEntidades {
    String nombre;
    Integer id;

    public ValoresConsultaEntidades(String nombre, Integer id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
