package Controllers;

import ClasesDominio.Entidad;
import ClasesDominio.ValoresConsultaIncidentes;

import java.sql.*;
import java.util.List;

public class IncidenteController {
  String url ="jdbc:mysql://localhost:3306/sacmr";
  String username ="root";
  String password ="DDS_GRUPO_7_2023!";


  private List<ValoresConsultaIncidentes> valores;

  private List<ValoresConsultaIncidentes> obtenerIncidentesDe(String idEntidad){
    try {
    Connection conexion = DriverManager.getConnection(url, username, password);

    Statement statement = conexion.createStatement();

    ResultSet resultSet = statement.executeQuery("select estado, fecha_apertura, fecha_cierre from incidentes join Servicio s on s.id = servicioAfectado_id join Entidad e on e.id = s.id_establecimiento where e.id = "+idEntidad);

    conexion.close();
    statement.close();
    resultSet.close();
  } catch (
  SQLException e) {
    throw new RuntimeException(e);
  }
    return null;
}
}
