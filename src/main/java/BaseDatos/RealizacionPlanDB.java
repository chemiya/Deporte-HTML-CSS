/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import modelo.MaterialEntrenamiento;

/**
 *
 * @author chemi
 */
public class RealizacionPlanDB {
     public static void insert(String username,String idPlan) {
ConnectionPool pool = ConnectionPool.getInstance();
Connection connection = pool.getConnection();
PreparedStatement ps = null;
String query="INSERT INTO realizacionPlan VALUES (?, ?,?,0)";
try {
ps = connection.prepareStatement(query);
ps.setString(1, username);
ps.setString(2, idPlan);
ps.setString(3, LocalDate.now().toString());

int res = ps.executeUpdate();
ps.close();
pool.freeConnection(connection);

} catch (SQLException e) {
e.printStackTrace();

}
} 
}
