package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
    private static Connection connection;
    private static Statement statement;

    //com.mysql.jdbc.Driver
    //oracle.jdbc.driver.OracleDriver
    //org.postgresql.Driver
    //com.microsoft.sqlserver.jdbc.SQLServerDrive
    //org.sqlite.JDBC

    public static Connection ConnectionOlustur(String hostname,String databaseismi,String username, String password){
        //1.adım: drivera kaydol
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //2.adım: connection olustur
        //url syntax:jdbc:postgresql://hostname:portnumber/databaseismi
        String url="jdbc:postgresql://"+hostname+":5432/"+databaseismi;

        try {
            connection= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static Statement statementOlustur(){
        try {
            statement= connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    public static void connectionStatementKapat(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





}
