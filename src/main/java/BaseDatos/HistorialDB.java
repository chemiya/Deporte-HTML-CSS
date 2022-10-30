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
import modelo.Dificultad;
import modelo.Entrenamiento;
import modelo.Historial;

/**
 *
 * @author chemi
 */
public class HistorialDB {
     public static Historial obtenerHistorial(String username){
        ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;
Historial ent=new Historial();

String query = "SELECT * from Historial "+ "WHERE username=?";


    try {
ps = connection.prepareStatement(query);
ps.setString(1, username);

rs = ps.executeQuery();
while(rs.next()){
   
   ent.setEntrenamientosCompletos((rs.getInt("entrenamientosCompletos")));
    ent.setPlanesCompletos((rs.getInt("planesCompletos")));
     ent.setTiempoEntrenamiento((rs.getInt("tiempoEntrenamiento")));
      ent.setOpiniones((rs.getInt("opiniones")));
       ent.setEntrenamientosCreados((rs.getInt("entrenamientosCreados")));
       
    
}
rs.close();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}


return ent;
    }
    
}
