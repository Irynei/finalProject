package football_events.enrichers;

import football_events.udfs.GetDescriptionByEvent;
import football_events.udfs.GetTeamByPlayer;
import org.apache.spark.sql.DataFrame;
import org.springframework.stereotype.Component;

import static org.apache.spark.sql.functions.callUDF;
import static org.apache.spark.sql.functions.col;

/**
 * Created by irko on 25.12.17.
 */
@Component
public class EventDescriptionEnricher implements Enricher {
    private static final String EVENT_DESCRIPTION_COLUMN = "description";
    private static final String CODE_COLUMN = "code";

    @Override
    public DataFrame enrich(DataFrame dataFrame) {
        return dataFrame.withColumn(EVENT_DESCRIPTION_COLUMN, callUDF(GetDescriptionByEvent.class.getName(), col(CODE_COLUMN)));
    }
}
