package com.example.apiservicioranking.Controllers;


import com.example.apiservicioranking.ClasesDominio.MisDatos;
import com.example.apiservicioranking.Servicios.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ranking")
public class RankingController {
  @Autowired
  RankingService servicioRanking;

  @GetMapping
  public MisDatos getRanking(){
    return servicioRanking.obtenerRankingImpactoIncidentes().getBody();
  }
}
