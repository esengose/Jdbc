package utilities.tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class C01 {

    @Test
    public void test01() throws SQLException {
        String hostname="localhost";
        String dbisim="Databasetesting";
        String username= "postgres";
        String password="esenxx";

        DBUtils.ConnectionOlustur(hostname,dbisim,username,password);
        Statement st= DBUtils.statementOlustur();

        // Ogrenciler arasında

        String query="select isim from ogrenciler";
        ResultSet rset= st.executeQuery(query);
        List<String> isimler=new ArrayList<>();
        while(rset.next()){
            isimler.add(rset.getString(1));
        }

        Assert.assertTrue(isimler.contains("Merve Gul"));

        DBUtils.connectionStatementKapat();
    }
}
