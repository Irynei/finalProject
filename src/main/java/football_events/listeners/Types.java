package football_events.listeners;

import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;

/**
 * Created by irko on 25.12.17.
 */

public enum Types {
    STRING("string", DataTypes.StringType), BOOLEAN("boolean", DataTypes.BooleanType)
    ,INTEGER("integer", DataTypes.IntegerType);

    private String stringValue;
    private DataType sparkType;

    Types(String stringValue, DataType sparkType) {
        this.stringValue = stringValue;
        this.sparkType = sparkType;
    }

    public DataType getSparkType() {
        return this.sparkType;
    }

    public static DataType convertToSparkType(Types inputType) {
        for (Types type : Types.values()) {
            if (type.equals(inputType)) {
                 return type.getSparkType();
            }
        }
        throw new IllegalStateException(inputType + " is not supported.");
    }
}
