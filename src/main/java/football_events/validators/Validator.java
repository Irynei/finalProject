package football_events.validators;

import org.apache.spark.sql.DataFrame;

/**
 * Created by irko on 25.12.17.
 */

public interface Validator {
    DataFrame validate(DataFrame dataFrame);
}
