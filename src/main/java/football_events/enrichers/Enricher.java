package football_events.enrichers;

import org.apache.spark.sql.DataFrame;

/**
 * Created by irko on 25.12.17.
 */
public interface Enricher {
    DataFrame enrich(DataFrame dataFrame);
}
