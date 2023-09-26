package com.example.apiservicioranking.Controllers;

import com.example.apiservicioranking.ClasesDominio.ValoresConsultaEntidades;

import java.sql.*;
import java.util.List;

public class EntidadController {
    String url ="jdbc:mysql://localhost:3306/sacmr";
    String username ="root";
    String password ="DDS_GRUPO_7_2023!";


    private List<ValoresConsultaEntidades> valores;

    public List<ValoresConsultaEntidades> obtenerEntidades(){
        try {
            Connection conexion = DriverManager.getConnection(url, username, password);

            Statement statement = conexion.createStatement();

            ResultSet resultSet = statement.executeQuery("select id, NombreEntidad from entidad");

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String nombre = resultSet.getString("NombreEntidad");
                this.valores.add(new ValoresConsultaEntidades(nombre,id));
            }

            conexion.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.valores;
    }
}