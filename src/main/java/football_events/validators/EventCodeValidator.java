package football_events.validators;

import football_events.annotations.ShowDataFrameInTheBeginning;
import football_events.udfs.ValidateEventCode;
import org.apache.spark.sql.DataFrame;
import org.springframework.stereotype.Component;

import static org.apache.spark.sql.functions.callUDF;
import static org.apache.spark.sql.functions.col;

/**
 * Created by irko on 25.12.17.
 */

@Component
public class EventCodeValidator implements Validator {
    private static final String CODE_COLUMN = "code";

    @Override
    @ShowDataFrameInTheBeginning
    public DataFrame validate(DataFrame dataFrame) {
        return dataFrame.filter(callUDF(ValidateEventCode.class.getName(), col(CODE_COLUMN)));
    }
}
