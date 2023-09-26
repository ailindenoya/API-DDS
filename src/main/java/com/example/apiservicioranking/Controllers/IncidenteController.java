package com.example.apiservicioranking.Controllers;

import com.example.apiservicioranking.ClasesDominio.EstadoIncidente;
import com.example.apiservicioranking.ClasesDominio.ValoresConsultaIncidentes;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class IncidenteController {
  String url ="jdbc:mysql://localhost:3306/sacmr";
  String username ="root";
  String password ="DDS_GRUPO_7_2023!";


  private List<ValoresConsultaIncidentes> valores;

  public List<ValoresConsultaIncidentes> obtenerIncidentesDe(String idEntidad){
    try {
      Connection conexion = DriverManager.getConnection(url, username, password);
      Statement statement = conexion.createStatement();

      ResultSet resultSet = statement.executeQuery("select estado, fechaApertura, fechaCierre from incidentes join Servicio s on s.id = servicioAfectado_id join Entidad e on e.id = s.id_establecimiento where e.id = "+idEntidad);
      while(resultSet.next()){
        EstadoIncidente estado = EstadoIncidente.fromInt(resultSet.getInt("estado"));
        LocalDate fechaApertura = resultSet.getDate("fechaApertura").toLocalDate();
        LocalDate fechaCierre = resultSet.getDate("fechaCierre").toLocalDate();
        this.valores.add(new ValoresConsultaIncidentes(estado,fechaApertura, fechaCierre));
      }
      conexion.close();
      statement.close();
      resultSet.close();
    }catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return this.valores;
  }
}
