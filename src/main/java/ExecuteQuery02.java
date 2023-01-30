import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","esenxx");
        Statement st= con.createStatement();

       //1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan company ve number_of_employees değerlerini çağırın.
        String sql1= "SELECT company,number_of_employees FROM companies\n" +
                "ORDER BY number_of_employees DESC OFFSET 1 ROW FETCH NEXT 1 ROW ONLY";
        ResultSet rs1= st.executeQuery(sql1);
        while(rs1.next()){
            System.out.println(rs1.getString("company") +"--"+ rs1.getString("number_of_employees"));
        }
    // 2.Örnek: Aynı soruyu subquery ile yapınız
         String sql2= "SELECT company, number_of_employees\n" +
                 "FROM companies\n" +
                 "WHERE number_of_employees = (SELECT MAX(number_of_employees)\n" +
                 "                            FROM companies\n" +
                 "                            WHERE number_of_employees < (SELECT MAX(number_of_employees)\n" +
                 "                                                         FROM companies));\n";
        ResultSet rs2= st.executeQuery(sql2);

        while(rs2.next()){
           // System.out.println(rs1.getString("company") +"--"+ rs1.getString("number_of_employees"));
        }
        con.close();
        st.close();
        rs1.close();
        rs2.close();




    }
}
