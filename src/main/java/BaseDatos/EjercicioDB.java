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
import java.util.ArrayList;
import modelo.Dificultad;
import modelo.Ejercicio;
import modelo.Entrenamiento;

/**
 *
 * @author chemi
 */
public class EjercicioDB {
    public static Ejercicio asociarDatos(int idEjercicio){
        ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
Ejercicio ent=new Ejercicio();

String query = "SELECT * from Ejercicio where idEjercicio=? ";


    try {
ps = connection.prepareStatement(query);
ps.setString(1, String.valueOf(idEjercicio));

rs = ps.executeQuery();
while(rs.next()){
   
    ent.setNombre(rs.getString("nombre"));
    ent.setDescripcion(rs.getString("descripcion"));
    ent.setVideoUrl(rs.getString("videourl"));
     ent.setIdEjercicio(rs.getInt("idEjercicio"));
       
    
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}


return ent;
    }
    
    
    
    public static ArrayList<Ejercicio> buscarSimilares(String nombre){
          ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
ArrayList<Ejercicio> array=new ArrayList<Ejercicio>();

String query = "SELECT * from Ejercicio ";


    try {
ps = connection.prepareStatement(query);


rs = ps.executeQuery();
while(rs.next()){
   
    if(rs.getString("nombre").contains(nombre)){
         Ejercicio anadir=new Ejercicio();
    anadir.setNombre(rs.getString("nombre"));
    anadir.setDescripcion(rs.getString("descripcion"));
    anadir.setIdEjercicio(rs.getInt("idEjercicio"));
    array.add(anadir);
        
    }
   
       
    
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}


return array;
    }
}
