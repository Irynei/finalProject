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
public class GetTeamByPlayer implements UDF1<String, String> {

    @AutowiredBroadcast
    private Broadcast<FootballConfig> broadcast;

    @Override
    public String call(String player) throws Exception {
        return broadcast.value().getPlayerToCountry().get(player);
    }
}
