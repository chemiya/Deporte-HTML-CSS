/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import BaseDatos.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.RealizacionEntrenamiento;
import modelo.Usuario;

/**
 *
 * @author chemi
 */
public class RealizacionEntrenamientoDB {
     public static ArrayList<RealizacionEntrenamiento> buscarResultadosEntrenamiento(String inicio,String finalFecha,String username) {
ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
ArrayList<RealizacionEntrenamiento> realizados=new ArrayList<RealizacionEntrenamiento>();
String query = "SELECT * FROM realizacionEntrenamiento "+ "WHERE username = ? and fecha>? and fecha<? ";
try {
ps = connection.prepareStatement(query);
ps.setString(1, username);
ps.setString(2, inicio);
ps.setString(3, finalFecha);

rs = ps.executeQuery();
while(rs.next()){
    RealizacionEntrenamiento realizacion=new RealizacionEntrenamiento();
    realizacion.setIdEntrenamiento(rs.getInt("idEntrenamiento"));
     realizacion.setFecha(rs.getDate("fecha"));
      realizacion.setHora(rs.getTime("hora"));
    realizados.add(realizacion);
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}

return realizados;
} 
}
