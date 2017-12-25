package football_events.validators;

import football_events.annotations.ShowDataFrameInTheBeginning;
import football_events.udfs.ValidateMatchTime;
import org.apache.spark.sql.DataFrame;
import org.springframework.stereotype.Component;

import static org.apache.spark.sql.functions.callUDF;
import static org.apache.spark.sql.functions.col;

/**
 * Created by irko on 25.12.17.
 */

@Component
public class TimeValidator implements Validator {

    private static final String EVENT_TIME_COLUMN = "eventTime";
    private static final String START_TIME_COLUMN = "startTime";

    @Override
    @ShowDataFrameInTheBeginning
    public DataFrame validate(DataFrame dataFrame) {
        return dataFrame.filter(callUDF(ValidateMatchTime.class.getName(), col(EVENT_TIME_COLUMN)))
                .filter(callUDF(ValidateMatchTime.class.getName(), col(START_TIME_COLUMN)));
    }
}
