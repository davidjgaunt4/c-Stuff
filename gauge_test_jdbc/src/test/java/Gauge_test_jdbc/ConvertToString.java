package Gauge_test_jdbc;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class  ConvertToString {
        public static List<DataSet> serialize(ResultSet rs) throws Exception {

            try {
                ResultSetMetaData rsmd = rs.getMetaData();
                int numColumns = rsmd.getColumnCount();

                List<DataSet> ds = new ArrayList<DataSet>();

                for (int i = 0; i < numColumns; i++) {
                    DataSet localDs=new DataSet();
                    localDs.columnName = rsmd.getColumnLabel(i + 1);
                    localDs.columnTypes = rsmd.getColumnType(i + 1);
                ds.add(localDs);
                }



                while (rs.next()) {

                    boolean b;
                    long l;
                    double d;

                    for (int i = 0; i < ds.size(); i++)
                        switch (ds.get(i).columnTypes) {

                            case Types.INTEGER:
                                l = rs.getInt(i + 1);
                                if (rs.wasNull()) {
                                    ds.get(i).columnValue = "empty";
                                } else {
                                    ds.get(i).columnValue = Long.toString(l);//jgen.writeNumber(l);
                                }
                                break;

                            case Types.BIGINT:
                                l = rs.getLong(i + 1);
                                if (rs.wasNull()) {
                                    ds.get(i).columnValue = "empty";
                                } else {
                                    ds.get(i).columnValue = Long.toString(l);
                                }
                                break;

                            case Types.DECIMAL:
                            case Types.NUMERIC:
                                BigDecimal c = rs.getBigDecimal(i+1);
                                ds.get(i).columnValue = String.valueOf(c.doubleValue());
                                break;

                            case Types.FLOAT:
                            case Types.REAL:
                            case Types.DOUBLE:
                                d = rs.getDouble(i + 1);
                                if (rs.wasNull()) {
                                    //  jgen.writeNull();
                                } else {
                                    ds.get(i).columnValue=Double.toString(d);
                                }
                                break;

                            case Types.NVARCHAR:
                            case Types.VARCHAR:
                            case Types.LONGNVARCHAR:
                            case Types.LONGVARCHAR:
                                ds.get(i).columnValue=(rs.getString(i + 1));
                                break;

                            default:
                                //provider.defaultSerializeValue(rs.getObject(i + 1), jgen);
                                break;
                        }

                    //jgen.writeEndObject();
                }
                return ds;
              //  jgen.writeEndArray();

            } catch (SQLException e) {
                throw new Exception(e);
            }

        }
    }

//                            case Types.BOOLEAN:
//                            case Types.BIT:
//                                b = rs.getBoolean(i + 1);
//                                if (rs.wasNull()) {
//                                      jgen.writeNull();
//                                } else {
//                                    jgen.writeBoolean(b);
//                                }
//                                break;
//
//                            case Types.BINARY:
//                            case Types.VARBINARY:
//                            case Types.LONGVARBINARY:
//                                jgen.writeBinary(rs.getBytes(i + 1));
//                                break;
//
//                            case Types.TINYINT:
//                            case Types.SMALLINT:
//                                l = rs.getShort(i + 1);
//                                if (rs.wasNull()) {
//                                      jgen.writeNull();
//                                } else {
//                                    jgen.writeNumber(l);
//                                }
//                                break;
//
//                            case Types.DATE:
// provider.defaultSerializeDateValue(rs.getDate(i + 1), jgen);
//                                break;

//                            case Types.TIMESTAMP:
// provider.defaultSerializeDateValue(rs.getTime(i + 1), jgen);
//                                break;

//                            case Types.BLOB:
//                                Blob blob = rs.getBlob(i);
//provider.defaultSerializeValue(blob.getBinaryStream(), jgen);
//                                blob.free();
//                                break;

//                            case Types.CLOB:
//                                Clob clob = rs.getClob(i);
//provider.defaultSerializeValue(clob.getCharacterStream(), jgen);
//                                clob.free();
//                                break;

//                            case Types.ARRAY:
//                                throw new RuntimeException("ResultSetSerializer not yet implemented for SQL type ARRAY");

//                            case Types.STRUCT:
//                                throw new RuntimeException("ResultSetSerializer not yet implemented for SQL type STRUCT");
//
//                            case Types.DISTINCT:
//                                throw new RuntimeException("ResultSetSerializer not yet implemented for SQL type DISTINCT");

//                            case Types.REF:
//                                throw new RuntimeException("ResultSetSerializer not yet implemented for SQL type REF");

//  case Types.JAVA_OBJECT:
