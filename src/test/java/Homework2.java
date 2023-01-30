import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Homework2 {
    //User connects to the database
    //JdbcUtils.connectToDataBase("medunna.com","medunna_db","medunna_user","medunna_pass_987");
    //Statement statement = JdbcUtils.createStatement();
    //User sends the query to get the names of "patient_id" column from "appointment" table
    //Assert that there are some appointment patient_id "405892".
    //Assert verify patients have 20295
    //User closes the connection


    @Test
    public void MedunnaPatientTest() throws SQLException {
        JdbcUtils.connectToDataBase("medunna.com","medunna_db","medunna_user","medunna_pass_987");
        Statement statement = JdbcUtils.createStatement();

        String str="SELECT patient_id FROM appointment";
        List<String> list=new ArrayList<>();
        ResultSet rset= statement.executeQuery(str);
        while(rset.next()){
            list.add(rset.getString(1));
        }
        System.out.println(list.size());
        Assert.assertTrue(list.contains("405892"));
        Assert.assertEquals(20295,list.size());
        JdbcUtils.closeConnectionAndStatement();


        }





}
