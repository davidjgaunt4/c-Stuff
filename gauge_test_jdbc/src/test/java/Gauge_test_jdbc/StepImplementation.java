package Gauge_test_jdbc;

import com.thoughtworks.gauge.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace;

import com.thoughtworks.gauge.datastore.*;

public class StepImplementation implements DbConstants {

    private HashSet<Character> vowels;

    DataStore specStore = DataStoreFactory.getSpecDataStore();
    private static String ACTUAL = "Actual_";
    private static String EXPECTED = "Expected_";
    private static String GMC_ID_GENERIC_DESCRIPTOR = "GMCID";
    private static String SINGLE ="Single_";
    private DataAdapter ob;
    @BeforeSpec
    public void setUp(){
        ob = new DataAdapter();
        ob.OpenDBConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    @AfterSpec
    public void teardown() throws SQLException {
        ob.closeDBConnection();

    }

    @Step("Assert expected value for <ExpectedValue> equals actual value for <ActualValue>")
    public void openDBConnection(String argExpectedValue, String argActualValue) throws Exception {
        String expected = specStore.get(EXPECTED + argExpectedValue).toString();
        String actual = specStore.get(ACTUAL + argActualValue).toString();
        assertThat(actual).isEqualTo(expected);

        for (Map.Entry<Object, Object> obj : specStore.entrySet()) {
            Gauge.writeMessage("Key: " + obj.getKey().toString() + "| Value: " + obj.getValue().toString());

        }


    }


    @Step("get expected results <SQL>")
    public void getExpectedValues(String sql) throws Exception {
        setSpecStoreValuesFromSQL(sql, EXPECTED);
    }

    @Step("get actual results <SQL>")
    public void getActualValues(String sql) throws Exception {
        setSpecStoreValuesFromSQL(sql, ACTUAL);
    }

    @Step("get field value with <select person_uid as {GMC_ID} from account where firstname='John' and lastname='Smith' and GP = 'Y' and specialist='N' and rownum=1>")
    public void getField(String sql) throws Exception {
        setSpecStoreValuesFromSQL(sql,SINGLE);

    }






    private void setSpecStoreValuesFromSQL(String sql, String descriptor) throws Exception {


        if(!(descriptor.equals(SINGLE)) && sql.contains("{"))
        {
            String columnName = getColumnName(sql);
            String value = specStore.get(SINGLE + columnName).toString();
            if (value.isEmpty())
            {
              throw new Exception("No value found for column named: " + columnName);
            }

            String match = "{" + columnName + "}";
            String replace = "'" + value + "'";
            sql = sql.replace(match, replace);
        }
        else if(sql.contains("{")){
            sql=removeParenthasis(sql);
        }


        //      if (descriptor.equals(ACTUAL) && sql.contains("{")) {
//

  //          String columnName = getColumnName(sql);
   //         String value = specStore.get(EXPECTED + columnName).toString();
  //          if (value.isEmpty()) {
  //              throw new Exception("No value found for column named: " + columnName);
  //          }

 //           String match = "{" + columnName + "}";
 //           String replace = "'" + value + "'";
//            sql = sql.replace(match, value);
//        }
//
//
        List<DataSet> sblDs = ob.executeQuery(sql);

        for (DataSet ds : sblDs) {
            specStore.put(descriptor + ds.columnName, ds.columnValue);
       }

    }

    private String getColumnName(String sql) {
        int start = sql.indexOf("{") + 1;
        int end = sql.indexOf("}");
        return sql.substring(start, end);
    }


    private String getColumnValueFromDataset(List<DataSet> sblDs, String columnName) throws Exception {
        for (DataSet set : sblDs) {
            if (set.columnName.equals(columnName)) {
                return set.columnValue;
            }
        }
        throw new Exception("No column name matching " + columnName + " exists in SQL Response");
    }




private String removeParenthasis(String text)
    {
      text=  text.replace("{","");
      text =  text.replace("}","");
        return text;
    }
}


