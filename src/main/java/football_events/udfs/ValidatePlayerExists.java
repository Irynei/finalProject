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
public class ValidatePlayerExists implements UDF1<String, Boolean> {

    @AutowiredBroadcast
    private Broadcast<FootballConfig> broadcast;


    @Override
    public Boolean call(String player) throws Exception {
        if (broadcast.value().getPlayerToCountry().containsKey(player)) {
            return true;
        } else {
            log.println(">>>Validation: " + " player " + player + " does not exist.");
            return false;
        }
    }
}
