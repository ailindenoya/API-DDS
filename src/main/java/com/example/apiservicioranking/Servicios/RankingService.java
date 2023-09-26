package com.example.apiservicioranking.Servicios;


import com.example.apiservicioranking.ClasesDominio.*;
import com.example.apiservicioranking.Controllers.EntidadController;
import com.example.apiservicioranking.Controllers.IncidenteController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RankingService {

  private double coeficienteCNF = 0.5;

  public ResponseEntity<MisDatos> obtenerRankingImpactoIncidentes(){
    //Declaro lista para ir guardando resultados
    List<ValorEntidadReporte> resultados = new ArrayList<>();

    EntidadController entidadController = new EntidadController();
    IncidenteController incidenteController = new IncidenteController();
    //Obtener todas las entidades
    List<ValoresConsultaEntidades> entidades = entidadController.obtenerEntidades();
    //Por cada entidad recuperar sus incidentes y hacer calculo
    if(entidades != null) {
      for (ValoresConsultaEntidades entidad : entidades) {
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
    MisDatos data = new MisDatos(nombreRanking,resultados);
    return ResponseEntity.ok(data);
  }


}
