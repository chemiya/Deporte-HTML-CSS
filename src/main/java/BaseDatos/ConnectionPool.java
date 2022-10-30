/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

/**
 *
 * @author chemi
 */
import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import org.apache.commons.dbcp2.BasicDataSource;
public class ConnectionPool {
private static ConnectionPool pool = null;
private static BasicDataSource basicDataSource = null;
private final String DB="definitiva2";
    private final String URL="jdbc:mysql://localhost:3306/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER="root";
    private final String PASS="";
private ConnectionPool() {
try {
basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);
        
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWaitMillis(-1);
}
catch(Exception e) {
e.printStackTrace();
}
}
public static ConnectionPool getInstance() {
if (pool == null) {
pool = new ConnectionPool();
}
return pool;
}
public Connection getConnection() {
try {
return basicDataSource.getConnection();
}
catch (SQLException sqle) {
sqle.printStackTrace();
return null;
}
}
public void freeConnection(Connection c) {
try {
c.close();
}
catch (SQLException sqle) {
sqle.printStackTrace();
}
}
}
