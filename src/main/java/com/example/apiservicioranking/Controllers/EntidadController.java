package com.example.apiservicioranking.Controllers;

import com.example.apiservicioranking.ClasesDominio.ValoresConsultaEntidades;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntidadController {
    String url ="jdbc:mysql://localhost:3306/sacmr";
    String username ="root";
    String password ="DDS_GRUPO_7_2023!";


    private List<ValoresConsultaEntidades> valores = new ArrayList<>();

    public List<ValoresConsultaEntidades> obtenerEntidades(){
        try {
            Connection conexion = DriverManager.getConnection(url, username, password);

            Statement statement = conexion.createStatement();

            ResultSet resultSet = statement.executeQuery("select id from entidad");

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                this.valores.add(new ValoresConsultaEntidades(id));
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