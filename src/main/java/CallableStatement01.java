import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","esenxx");
        Statement st= con.createStatement();
        /*
Java'da methodlar return type sahibi olsa da olmasa da method olarak adlandırılır.
SQL'de ise data return ediyorsa "function" denir. Return yapmıyorsa "procedure" olarak adlandırılır.
 */
        //Callable Statement ile function çağrmayı parametrelendireceğiz
        //1.Function kodunu yazıyoruz
        String sql1="CREATE OR REPLACE FUNCTION toplamaf (x NUMERIC, y NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN \tx+y;\n" +
                "\n" +
                "END\n" +
                "$$\n";
        //2.Function ı çalıştırıyoruz
        st.execute(sql1);

        //3. Functionu çağırıyoruz
        CallableStatement cst1=con.prepareCall("{?= call toplamaF(?, ?)}");

        //4. Returnn için registerOurParameter() methodunu, parametreler için ise set() ... methodlarını uygulayacağız
        cst1.registerOutParameter(1,Types.NUMERIC);
        cst1.setInt(2,6);
        cst1.setInt(3,4);

        //5. execute() methodu ile CallableStatement ı çalıştırıyoruz
        cst1.execute();

        //6.Sonucu çağırmak için return data tipine göre
        System.out.println(cst1.getBigDecimal(1));

        //Koninin hacmini hesaplayan methodu yazınız
        String sql2="CREATE OR REPLACE FUNCTION konininHacmiF (r NUMERIC, h NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN \t3.14*r*r*h/3;\n" +
                "\n" +
                "END\n" +
                "$$\n";
        st.execute(sql2);
        CallableStatement cst2=con.prepareCall("{?= call konininHacmiF(?, ?)}");
        cst2.registerOutParameter(1,Types.NUMERIC);
        cst2.setInt(2,1);
        cst2.setInt(3,6);
        cst2.execute();
        System.out.println(cst2.getBigDecimal(1));




    }
}
