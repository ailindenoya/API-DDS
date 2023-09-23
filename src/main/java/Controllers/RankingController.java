package Controllers;


import ClasesDominio.MisDatos;
import Servicios.RankingService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RankingController {

  private RankingService servicio;

  public RankingController(RankingService servicio){
    this.servicio = servicio;
  }

  @GetMapping
  public MisDatos getRanking(@RequestParam Integer id){
    return servicio.getRanking(id);
  }
}
