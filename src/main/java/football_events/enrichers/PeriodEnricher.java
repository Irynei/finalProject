package football_events.enrichers;

import football_events.annotations.ShowDataFrameInTheBeginning;
import football_events.udfs.GetPeriodByEventTime;
import org.apache.spark.sql.DataFrame;
import org.springframework.stereotype.Component;

import static org.apache.spark.sql.functions.callUDF;
import static org.apache.spark.sql.functions.col;

/**
 * Created by irko on 25.12.17.
 */
@Component
public class PeriodEnricher implements Enricher {

    private static final String PERIOD_COLUMN = "period";
    private static final String EVENT_TIME_COLUMN = "eventTime";

    @Override
    @ShowDataFrameInTheBeginning
    public DataFrame enrich(DataFrame dataFrame) {
        return dataFrame.withColumn(PERIOD_COLUMN, callUDF(GetPeriodByEventTime.class.getName(), col(EVENT_TIME_COLUMN)));
    }
}
