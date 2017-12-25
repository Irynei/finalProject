package football_events.udfs;

import football_events.annotations.AutowiredBroadcast;
import football_events.FootballConfig;
import football_events.annotations.RegisterUDF;
import football_events.listeners.Types;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.api.java.UDF1;

/**
 * Created by irko on 25.12.17.
 */

@RegisterUDF(returnType = Types.STRING)
public class GetDescriptionByEvent implements UDF1<Integer, String> {

    @AutowiredBroadcast
    private Broadcast<FootballConfig> broadcast;

    @Override
    public String call(Integer code) throws Exception {
        return broadcast.value().getDescriptionToEventCode().get(code);
    }
}
