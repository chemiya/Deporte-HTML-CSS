/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.AreaEntrenamiento;
import modelo.Ejecuccion;
import modelo.Ejercicio;
import modelo.Entrenamiento;

/**
 *
 * @author chemi
 */
public class EjecuccionDB {
   public static ArrayList<Ejecuccion> obtenerEjecucciones(String idEntrenamiento){
        ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
ArrayList<Ejecuccion> ejecucciones=new ArrayList<Ejecuccion>();
int idMaterial=0;

String query = "SELECT * from Ejecuccion "+ "WHERE idEntrenamiento=?";


    try {
ps = connection.prepareStatement(query);
ps.setString(1, idEntrenamiento);

rs = ps.executeQuery();
while(rs.next()){
   
    Ejecuccion eje=new Ejecuccion();
    eje.setIdEjercicio(rs.getInt("idEjercicio"));
    eje.setDuracion(rs.getInt("duracion"));
     eje.setRepeticiones(rs.getInt("repeticiones"));
     ejecucciones.add(eje);
    
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}


return ejecucciones;
    } 
   
   
   
     public static void insert(String idEjercicio,String idEntrenamiento,String duracion) {
ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
String query="INSERT INTO Ejecuccion(idEntrenamiento,idEjercicio,duracion,repeticiones) VALUES (?, ?,?,null)";
try {
ps = connection.prepareStatement(query);
ps.setString(1, idEntrenamiento);
ps.setString(2, idEjercicio);
ps.setString(3, duracion);

int res = ps.executeUpdate();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}
}
     
     
     public static ArrayList<Ejecuccion> getEjercicios(int idEntren){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Ejecuccion> ejercicios = new ArrayList<>();
        String query="select * from ejecuccion where idEntrenamiento=?";
       
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(idEntren));
            rs = ps.executeQuery();
            
            while(rs.next()){
                Ejecuccion anadir=new Ejecuccion();
                anadir.setDuracion(rs.getInt("duracion"));
                anadir.setIdEjercicio(rs.getInt("idEjercicio"));
                ejercicios.add(anadir);
                
            }
           
            rs.close();
            ps.close();
            pool.freeConnection(connection);

        } catch (SQLException e) {
        e.printStackTrace();
        }
        return ejercicios;
    }
   
     
     
     
     
     
     
}
