package Controllers;


import ClasesDominio.Ranking;
import Servicios.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankingController {

  private RankingService servicio;

  @Autowired
  public RankingController(RankingService servicio){
    this.servicio = servicio;
  }

  @GetMapping
  public Ranking getRanking(@RequestParam Integer id){
    return servicio.getRanking(id);
  }
}
