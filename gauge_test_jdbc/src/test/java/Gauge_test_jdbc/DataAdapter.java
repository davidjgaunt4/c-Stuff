package Gauge_test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class DataAdapter {
private Connection connObj;
   private Statement stmObj;

    public  void  OpenDBConnection(String DB_URL, String DB_USERNAME, String DB_PASSWORD) {
        try {
            connObj=DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (Exception sqlException)
        {
            sqlException.printStackTrace();
        }


    }



    public List<DataSet> executeQuery (String query) throws Exception {

     stmObj = connObj.createStatement();
             return ConvertToString.serialize(stmObj.executeQuery(query));




    }

    public void closeDBConnection() throws SQLException {
        if(connObj!=null)
            connObj.close();

    }
}
