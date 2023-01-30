package utilities.tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C02 {
    //Yazılı not ortalamasının 90 dan küçük olduğunu test edin

    @Test
    public void test02() throws SQLException {
        DBUtils.ConnectionOlustur("localhost","Databasetesting","postgres","esenxx");
        Statement st=DBUtils.statementOlustur();

        String query="select AVG(yazili_notu) from ogrenciler";
        ResultSet rset= st.executeQuery(query);
        rset.next();
        double ort=rset.getDouble(1);
        System.out.println(ort);
        Assert.assertTrue(ort<90);

    }
}
