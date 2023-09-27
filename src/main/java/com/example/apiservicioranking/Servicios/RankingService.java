package com.example.apiservicioranking.Servicios;


import com.example.apiservicioranking.ClasesDominio.*;
import com.example.apiservicioranking.Controllers.EntidadController;
import com.example.apiservicioranking.Controllers.IncidenteController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class RankingService {

  private double coeficienteCNF = 0.5;

  public ResponseEntity<MisDatos> obtenerRankingImpactoIncidentes(){
    //Declaro lista para ir guardando resultados
    List<ValorEntidadReporte> resultados = new ArrayList<>();

    EntidadController entidadController = new EntidadController();

    //Obtener todas las entidades
    List<ValoresConsultaEntidades> entidades = entidadController.obtenerEntidades();
    //Por cada entidad recuperar sus incidentes y hacer calculo
    if(entidades != null) {
      for (ValoresConsultaEntidades entidad : entidades) {
        IncidenteController incidenteController = new IncidenteController();
        List<ValoresConsultaIncidentes> incidentes = incidenteController.obtenerIncidentesDe(String.valueOf(entidad.getId()));
        List<ValoresConsultaIncidentes> incidentesAbiertos = incidentes.stream().filter(i -> i.getEstadoIncidente() == EstadoIncidente.ABIERTO).toList();
        List<ValoresConsultaIncidentes> incidentesCerrados = incidentes.stream().filter(i -> i.getEstadoIncidente() == EstadoIncidente.CERRADO).toList();
        int cantidadNoResueltos = incidentesAbiertos.size();
        long tiempoResolucion = incidentesCerrados.stream().mapToLong(ValoresConsultaIncidentes::getTiempoResolucion).sum();


        double valorImpacto = tiempoResolucion + (cantidadNoResueltos * coeficienteCNF);

        ValorEntidadReporte valorResultado = new ValorEntidadReporte(entidad.getNombre(), valorImpacto);
        resultados.add(valorResultado);
      }
    }
    String nombreRanking = "Ranking - "+ LocalDate.now();
    List<ValorEntidadReporte> resultadosOrdenados = ordenarLista(resultados);
    MisDatos data = new MisDatos(nombreRanking,resultadosOrdenados);
    return ResponseEntity.ok(data);
  }

  private List<ValorEntidadReporte> ordenarLista(List<ValorEntidadReporte> valores){
    Collections.sort(valores);
    return valores;
  }


}
