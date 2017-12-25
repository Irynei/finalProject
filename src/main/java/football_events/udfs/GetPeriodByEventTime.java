package football_events.udfs;

import football_events.annotations.RegisterUDF;
import football_events.listeners.Types;
import org.apache.spark.sql.api.java.UDF1;

/**
 * Created by irko on 25.12.17.
 */

@RegisterUDF(returnType = Types.INTEGER)
public class GetPeriodByEventTime implements UDF1<String, Integer> {

    @Override
    public Integer call(String eventTime) throws Exception {
        Integer minutes = Integer.parseInt(eventTime.split(":")[0]);
        return minutes >= 45 ? 2: 1;
    }
}
