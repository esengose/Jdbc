import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Homework1 {
    //User connects to the database
    // JdbcUtils.connectToDataBase("medunna.com","medunna_db","medunna_user","medunna_pass_987");
    //Statement statement = JdbcUtils.createStatement();
    //User sends the query to get the names of "email" column from "cmessage" table
    //Assert that there are some "cmessage" email "zeynep05@gmail.com".
    //User closes the connection

    @Test
    public void MedunnaMessageEmailTest() throws SQLException {
        JdbcUtils.connectToDataBase("medunna.com","medunna_db","medunna_user","medunna_pass_987");
        Statement statement =JdbcUtils.createStatement();
        String str="SELECT email FROM cmessage";
        List<String> list=new ArrayList<>();
        ResultSet rs1=statement.executeQuery(str);
        while(rs1.next()) {
            list.add(rs1.getString(1));
        }
        Assert.assertTrue(list.contains("zeynep05@gmail.com"));
        JdbcUtils.closeConnectionAndStatement();
    }


}
