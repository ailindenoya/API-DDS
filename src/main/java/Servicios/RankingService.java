package Servicios;

import ClasesDominio.MisDatos;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class RankingService {

  private double coeficienteCNF = 0.5;
  public MisDatos getRanking(Integer id){
    return null;
  }

  @GetMapping("/rankingIncidentes")
  private ResponseEntity<MisDatos> obtenerRankingImpactoIncidentes(){

    return null;




  }


}
