import java.sql.*;

public class JDStudies01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","esenxx");
        Statement st= con.createStatement();

        //Select the country ids and country names whose region ida are greater than 2
        String sql1="SELECT country_id,country_name FROM countries WHERE region_id>2";
        ResultSet rs1= st.executeQuery(sql1);
        while(rs1.next()){
            System.out.println(rs1.getString("country_id")+rs1.getString("country_name"));
        }
        //the lowest salary
        String sql2="SELECT * FROM  companies WHERE salary =(SELECT MIN(salary) FROM companies)";
        ResultSet rs2= st.executeQuery(sql2);
        while(rs2.next()){
            System.out.println(rs2.getString("id")+rs2.getString("name"));
        }











    }
}