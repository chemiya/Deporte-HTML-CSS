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
import modelo.AreaEntrenamiento;
import modelo.Entrenamiento;
import modelo.RealizacionEntrenamiento;

/**
 *
 * @author chemi
 */
public class AreaDB {
   public static int obtenerID(String valor){
        ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
Entrenamiento ent=new Entrenamiento();
int idArea=0;

String query = "SELECT idArea FROM Area "+ "WHERE valor=?";


    try {
ps = connection.prepareStatement(query);
ps.setString(1, valor);

rs = ps.executeQuery();
while(rs.next()){
   
    idArea=rs.getInt("idArea");
    
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}


return idArea;
    } 
   
   
     public static void insert(AreaEntrenamiento ae) {
ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
String query="INSERT INTO AreaEntrenamiento VALUES (?, ?)";
try {
ps = connection.prepareStatement(query);
ps.setString(1, String.valueOf(ae.getIdArea()));
ps.setString(2, String.valueOf(ae.getIdEntrenamiento()));

int res = ps.executeUpdate();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}
} 
}
