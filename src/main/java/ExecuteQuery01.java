import javax.xml.transform.Result;
import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.adım: Driver a kaydol.
        Class.forName("org.postgresql.Driver");

        //2.adım: Database e bağlan.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","esenxx");

        //3.adım: Statement oluştur.
        Statement st= con.createStatement();

        //region_id si 1 olan country leri çağıralım
        //RECORD LARI görmek için executeQuery methodunu kullanmalıyız

        String sql1="SELECT country_name \n" +
                " FROM countries\n" +
                " WHERE region_id=1;";
        boolean result=st.execute(sql1);
        System.out.println(result);

        ResultSet rs1=st.executeQuery(sql1);
        while(rs1.next()){

            System.out.println(rs1.getString(1));
        }

        //region_id si 2 den büyük olan country id ve country name degerlerini çağırınız
        String sql2="SELECT country_id, country_name FROM countries WHERE region_id>2";
        ResultSet rs2=st.executeQuery(sql2);
        while(rs2.next()){
            System.out.println(rs2.getString("country_name")+"---"+rs2.getString("country_id"));
        }

        //3.Örnek: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.
        String sql3="SELECT * FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees)FROM companies)";
        ResultSet rs3=st.executeQuery(sql3);

        while(rs3.next()){
            System.out.println(rs3.getInt(1)+"--"+rs3.getString(2)+"--"+rs3.getInt(3));
        }




    }
}
