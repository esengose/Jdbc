import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Homework3 {

//User connects to the database
// JdbcUtils.connectToDataBase("medunna.com","medunna_db","medunna_user","medunna_pass_987");
 // Statement statement = JdbcUtils.createStatement();
//User sends the query to get the names of birth_date column from "staff" table
//Assert that there are some staff birth_date "2022-12-03 23:00:00".
//User closes the connection

    @Test
    public void MedunnaStaffBirthDay() throws SQLException {
        JdbcUtils.connectToDataBase("medunna.com","medunna_db","medunna_user","medunna_pass_987");
        Statement statement = JdbcUtils.createStatement();
        String query= "SELECT birth_date FROM staff";
        List<String> list=new ArrayList<>();
        ResultSet rs= statement.executeQuery(query);
        while(rs.next()){
            list.add(rs.getString(1));
        }
        Assert.assertTrue(list.contains("2022-12-03 23:00:00"));
        JdbcUtils.closeConnectionAndStatement();



    }
}
