package Gauge_test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleJdbcExample implements DbConstants {

    static Statement stmtObj;
    static Connection connObj;
    static ResultSet resultSetObj;

    public static void main(String[] args) {
        try {
            // Step 1 - Register Oracle JDBC Driver (Though This Is No Longer Required Since JDBC 4.0, But Added Here For Backward Compatibility!
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2 - Creating Oracle Connection Object
            connObj = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            if(connObj != null) {
                System.out.println("!! Connected With Oracle Database !!\n");
            }

            // Step 3 - Creating Oracle Statement Object
            stmtObj = connObj.createStatement();
String lastname ="Smith";
            // Step 4 - Execute SQL Query
            resultSetObj = stmtObj.executeQuery("Select person_uid,firstname,lastname from account where lastname='"+lastname+"'");
            while(resultSetObj.next()) {
                System.out.println(resultSetObj.getInt(1) + ", " + resultSetObj.getString(2) + ", " + resultSetObj.getString(3) + "$");
            }
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if(resultSetObj != null) {
                    resultSetObj.close();
                }
                if(stmtObj != null) {
                    stmtObj.close();
                }
                if(connObj != null) {
                    connObj.close();
                }
            } catch(Exception sqlException) {
                sqlException.printStackTrace();
            }
        }
    }
}