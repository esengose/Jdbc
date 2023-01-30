import java.sql.Connection;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {

        //1. Driver a kaydol
        //2. Database e bağlan
        JdbcUtils.connectToDataBase("localhost","techproed","postgres","esenxx");

        //3.Adım: Statement oluştur
        Statement statement= JdbcUtils.createStatement();

        //4. Adım: Query çalıştır.
       // JdbcUtils.execute("CREATE TABLE students (name VARCHAR(20), id INT, address VARCHAR(80))");
       // JdbcUtils.createTable("Schools","classes varchar(20)","teachername_name varchar(20)","id int");
        // 5.Bağlantı ve statementı kapat
        JdbcUtils.closeConnectionAndStatement();














    }
}
