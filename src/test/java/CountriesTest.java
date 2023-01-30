import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountriesTest {
    /*
        Given
          User connects to the database
        When
          User sends the query to get the region ids from "countries" table
        Then
          Verify that the number of region ids greater than 1 is 17.
        And
          User closes the connection
       */
    @Test
    public void countryTest() throws SQLException {
        JdbcUtils.connectToDataBase("localhost","techproed","postgres","esenxx");
        Statement statement =JdbcUtils.createStatement();

        String sql1="SELECT region_id FROM countries;";
        ResultSet rs1= statement.executeQuery(sql1);
        List<Integer> ids=new ArrayList<>();
        while(rs1.next()){
            ids.add(rs1.getInt(1));
        }
        System.out.println("ids = "+ ids);
        List<Integer> idsGreaterThan1=new ArrayList<>();
        for(int w: ids){
            if(w>1){
                idsGreaterThan1.add(w);
            }
        }
        System.out.println("idsGreaterThan1 :" +idsGreaterThan1);
        Assert.assertEquals(17,idsGreaterThan1.size());
        JdbcUtils.closeConnectionAndStatement();
    }


}
