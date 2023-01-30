import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    //1.adım: Driver a kaydol.
        Class.forName("org.postgresql.Driver");

     //2.adım: Database e bağlan.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","esenxx");

    //3.adım: Statement oluştur.
        Statement st= con.createStatement();

        System.out.println("Connection Success");

    //4.adım:  Query çalıştır
      //1. workers adında bir table oluşturup worler_id, worker_name, worker_salary sütunlarını oluşturalım

      boolean sql1=  st.execute("CREATE TABLE workers(\n" +
                "worker_id varchar(20),\n" +
               "worker_name varchar(20),\n" +
                "worker_salary int );");
        System.out.println("sq1 = "+ sql1 ); //false return eder çünkü data çağırmıyoruz
        //Bir daha run edersek hata alırız çünkü oluşturulmuş tabloyu tekrar oluşturmaya çalışıyoruz

        /*EXECUTE METHODU,  DDL( CREATE, DROP, ALTER) VE DQL (SELECT) İÇİN KULLANILIR
        1. Eğer execute() methodu DDL için kullanılırsa false return eder.
        2.Eğer execute() methodu DQL için kullanılırsa Resultset alınırsa true, aksi halde false return eder
         */

        //2. Workers tablosuna worker_adress sütunu ekleyelim alter yapalım

        String sql2="ALTER TABLE workers ADD workers_address VARCHAR(80)";
        st.execute(sql2);
        boolean sql2b= st.execute(sql2);

        //3. Tabloyu silelim
        String sql3= "DROP TABLE workers";
        st.execute(sql3);
        System.out.println(sql3);


        //5. adım Statement ve Connection kapat
        con.close();
        st.close();







    }
}
