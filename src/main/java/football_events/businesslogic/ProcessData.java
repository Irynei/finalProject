package football_events.businesslogic;

import football_events.businesslogic.DataFrameBuilder;
import football_events.enrichers.Enricher;
import football_events.validators.Validator;
import org.apache.spark.sql.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by irko on 25.12.17.
 */

@Service
public class ProcessData {

    @Autowired
    private DataFrameBuilder dataFrameBuilder;

    @Autowired
    private List<Enricher> enrichers;

    @Autowired
    private List<Validator> validators;

    public DataFrame runEnrichments(DataFrame dataFrame) {
        for (Enricher enricher : enrichers) {
            dataFrame = enricher.enrich(dataFrame);
        }
        return dataFrame;
    }

    public DataFrame runValidators(DataFrame dataFrame) {
        for (Validator validator : validators) {
            dataFrame = validator.validate(dataFrame);
        }
        return dataFrame;
    }

    public DataFrame runAll() {
        DataFrame dataFrame = dataFrameBuilder.load();
        dataFrame = this.runValidators(dataFrame);
        dataFrame = this.runEnrichments(dataFrame);
        return dataFrame;
    }
}
