package com.example.apiservicioranking.Controllers;

import com.example.apiservicioranking.ClasesDominio.EstadoIncidente;
import com.example.apiservicioranking.ClasesDominio.ValoresConsultaIncidentes;
import jakarta.websocket.server.PathParam;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/incidentes")
public class IncidenteController {
  String url ="jdbc:mysql://localhost:3306/sacmr";
  String username ="root";
  String password ="DDS_GRUPO_7_2023!";


  private List<ValoresConsultaIncidentes> valores = new ArrayList<>();

  public List<ValoresConsultaIncidentes> obtenerIncidentesDe(String id){
    try {
      Connection conexion = DriverManager.getConnection(url, username, password);
      Statement statement = conexion.createStatement();

      String query = String.format("select estado, fechaApertura, fechaCierre from Incidente inner join Servicios as s on s.id = servicioAfectado_id where s.idEntidad ='%s'", id);
      ResultSet resultSet = statement.executeQuery(query);
      while(resultSet.next()){
        EstadoIncidente estado = EstadoIncidente.fromInt(resultSet.getInt("estado"));
        byte[] datosBinariosFechaApertura = resultSet.getBytes("fechaApertura");
        byte[] datosBinariosFechaCierre = resultSet.getBytes("fechaCierre");

        LocalDate fechaApertura = obtenerFecha(datosBinariosFechaApertura);
        LocalDate fechaCierre = obtenerFecha(datosBinariosFechaCierre);
        this.valores.add(new ValoresConsultaIncidentes(estado,fechaApertura, fechaCierre));
      }
      conexion.close();
      statement.close();
      resultSet.close();
    }catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return this.valores;
  }

  private LocalDate obtenerFecha(byte [] data) throws SQLException, IOException {

    String fechaComoCadena = new String(data);

    // Parsea la cadena a un objeto LocalDate utilizando un DateTimeFormatter.
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.parse(fechaComoCadena, formatter);
    return localDate;
  }
}
