package Gauge_test_jdbc;

import javax.lang.model.type.ArrayType;
import java.sql.Array;

public class DataSet  {
    DataSet(){
        setColumnName("empty");
        setColumnTypes(-99);
        setColumnValue("empty");
    }

    public String columnName;

    public int columnTypes ;

    public int getColumnTypes() {
        return columnTypes;
    }

    public void setColumnTypes(int columnTypes) {
        this.columnTypes = columnTypes;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    public String columnValue;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }




}
