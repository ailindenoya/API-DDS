package Controllers;

import ClasesDominio.ServicioNotificacion;

import java.sql.*;

public class Conexion {

  public static void main(String[] args){
    String url ="jdbc:mysql://localhost:3306/sacmr";
    String username ="root";
    String password ="DDS_GRUPO_7_2023!";


    try {

          Connection conexion = DriverManager.getConnection(url, username, password);
          Statement statement = conexion.createStatement();

          ResultSet resultSet = statement.executeQuery("SELECT * FROM SERVICIONOTIFICACION");
          while(resultSet.next()){
            System.out.println(resultSet.getString("tipo"));
            System.out.println(resultSet.getString("id"));
          }
          conexion.close();
          statement.close();
          resultSet.close();
          }
    catch (SQLException e) {
          throw new RuntimeException(e);
    }
  }
}
