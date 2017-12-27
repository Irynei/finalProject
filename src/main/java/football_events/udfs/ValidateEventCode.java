package football_events.udfs;

import football_events.annotations.AutowiredBroadcast;
import football_events.FootballConfig;
import football_events.annotations.RegisterUDF;
import football_events.models.Types;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.api.java.UDF1;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by irko on 25.12.17.
 */
@RegisterUDF(returnType = Types.BOOLEAN)
public class ValidateEventCode implements UDF1<Integer, Boolean>{

    @AutowiredBroadcast
    private Broadcast<FootballConfig> broadcast;

    @Override
    public Boolean call(Integer code) throws Exception {
        if (broadcast.value().getDescriptionToEventCode().containsKey(code)) {
            return true;
        } else {
            log.println(">>>Validation: " + " event code " + code + " is not valid.");
            return false;
        }
    }
}
