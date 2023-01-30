import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedunnaTest {
    @Test
    public void medunnaTest() throws SQLException {
        JdbcUtils.connectToDataBase("medunna.com","medunna_db","medunna_user","medunna_pass_987");
        Statement statement =JdbcUtils.createStatement();

        String sql1="SELECT created_by FROM room;";
        ResultSet rs1= statement.executeQuery(sql1);
        List<String> created_by_list=new ArrayList<>();
        while(rs1.next()){
            created_by_list.add(rs1.getString(1));
        }
       // System.out.println(created_by_list);
        Assert.assertTrue(created_by_list.contains("john_doe"));

        JdbcUtils.closeConnectionAndStatement();







    }

}
