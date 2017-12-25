package football_events.enrichers;

import football_events.annotations.ShowDataFrameInTheBeginning;
import football_events.udfs.GetTeamByPlayer;
import org.apache.spark.sql.DataFrame;
import org.springframework.stereotype.Component;

import static org.apache.spark.sql.functions.callUDF;
import static org.apache.spark.sql.functions.col;

/**
 * Created by irko on 25.12.17.
 */

@Component
public class TeamEnricher implements Enricher {

    private static final String TEAM_COLUMN = "Team";
    private static final String PLAYER_COLUMN = "fromPlayer";

    @Override
    @ShowDataFrameInTheBeginning
    public DataFrame enrich(DataFrame dataFrame){
        return dataFrame.withColumn(TEAM_COLUMN, callUDF(GetTeamByPlayer.class.getName(), col(PLAYER_COLUMN)));
    }
}
