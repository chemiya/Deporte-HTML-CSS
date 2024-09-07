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
import modelo.MaterialEntrenamiento;

/**
 *
 * @author chemi
 */
public class MaterialDB {
    public static int obtenerID(String valor){
        ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
Entrenamiento ent=new Entrenamiento();
int idMaterial=0;

String query = "SELECT idMaterial FROM Material "+ "WHERE valor=?";


    try {
ps = connection.prepareStatement(query);
ps.setString(1, valor);

rs = ps.executeQuery();
while(rs.next()){
   
    idMaterial=rs.getInt("idMaterial");
    
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}


return idMaterial;
    } 
    
    
      public static void insert(MaterialEntrenamiento me) {
ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
String query="INSERT INTO MaterialEntrenamiento VALUES (?, ?)";
try {
ps = connection.prepareStatement(query);
ps.setString(1, String.valueOf(me.getIdMaterial()));
ps.setString(2, String.valueOf(me.getIdEntrenamiento()));

int res = ps.executeUpdate();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}
} 
}
