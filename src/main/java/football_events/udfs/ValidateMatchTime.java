package football_events.udfs;

import football_events.annotations.RegisterUDF;
import football_events.models.Types;
import org.apache.spark.sql.api.java.UDF1;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by irko on 25.12.17.
 */
@RegisterUDF(returnType = Types.BOOLEAN)
public class ValidateMatchTime implements UDF1<String, Boolean> {

    @Override
    public Boolean call(String eventTime) throws Exception {
        Integer minutes = Integer.parseInt(eventTime.split(":")[0]);
        if(minutes > 0 && minutes < 97) {
            return true;
        } else {
            log.println(">>>Validation: " + " event time " + eventTime + " is not valid.");
            return false;
        }
    }
}
