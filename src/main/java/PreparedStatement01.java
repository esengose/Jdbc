import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "esenxx");
        Statement st = con.createStatement();

        /*
PreparedStatement interface, birden çok kez çalıştırılabilen önceden derlenmiş bir SQL kodunu temsil eder.
Paremetrelendirilmiş SQL sorguları(query) ile çalışır. Bu sorguyu 0 veya daha fazla parametre ile kullanabiliriz.
 */
        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.

        String sql1 = "UPDATE companies SET number_of_employees= ? WHERE company= ? ;"; //dinamik hale getirmek için prepared statemen kalıbına soktuk
        PreparedStatement pst1 = con.prepareStatement(sql1);  // PreparedStatement objesi oluşturduk
        pst1.setInt(1, 9999);  // ilk soru işaretinin data type'ı int olduğu için, SetInt (1.parametreyi, 9999 yap) diyorum
        pst1.setString(2, "IBM"); //ikinci soru işaretinin data type'ı String oldugu için, SetString(2.parametreyi, "IBM" yap) diyorum
        int guncellenenSatirSayisi = pst1.executeUpdate();
        System.out.println("guncellenenSatirSayisi : " + guncellenenSatirSayisi);  //execuyeUpdate() int döndürür, çünkü güncellenen datanın sayısını verir

        String sql2 = "SELECT * FROM companies";
        ResultSet rs1 = st.executeQuery(sql2);
        while (rs1.next()) {
            System.out.println(rs1.getInt(1) + "--" + rs1.getString(2) + "--" + rs1.getString(3));
        }
        //2. Örnek: Prepared statement kullanarak company adı GOOGLE olan number_of_employees değerini 5555 olarak güncelleyin.
        pst1.setInt(1, 5555);
        pst1.setString(2, "GOOGLE");
        int guncellenenSatirSayisi2 = pst1.executeUpdate();
        System.out.println("guncellenenSatirSayisi2 : " + guncellenenSatirSayisi2);

        ResultSet rs2 = st.executeQuery(sql2);
        while (rs2.next()) {
            System.out.println(rs2.getInt(1) + "--" + rs2.getString(2) + "--" + rs2.getString(3));
        }
        con.close();
        st.close();
        rs1.close();
        rs2.close();
        pst1.close();


    }
}
