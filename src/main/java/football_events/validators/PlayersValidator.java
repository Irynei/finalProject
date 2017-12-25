package football_events.validators;

import football_events.annotations.ShowDataFrameInTheBeginning;
import football_events.udfs.ValidatePlayerExists;
import org.apache.spark.sql.DataFrame;
import org.springframework.stereotype.Component;

import static org.apache.spark.sql.functions.*;

/**
 * Created by irko on 25.12.17.
 */

@Component
public class PlayersValidator implements Validator {

    private static final String FROM_PLAYER_COLUMN = "fromPlayer";
    private static final String TO_PLAYER_COLUMN = "toPlayer";

    @Override
    @ShowDataFrameInTheBeginning
    public DataFrame validate(DataFrame dataFrame) {
        return dataFrame.filter(callUDF(ValidatePlayerExists.class.getName(), col(FROM_PLAYER_COLUMN)))
                .filter(callUDF(ValidatePlayerExists.class.getName(), col(TO_PLAYER_COLUMN)));
    }
}
