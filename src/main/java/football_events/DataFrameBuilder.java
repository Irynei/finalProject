package football_events;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by irko on 25.12.17.
 */
@Service
public class DataFrameBuilder {

    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private SQLContext sqlContext;

    @Value("${dataPath}")
    private String dataPath;

    public DataFrame load() {
        JavaRDD<String> lines = sc.textFile(dataPath);
        JavaRDD<FootballMatchEvent> footballMatchEventRDD = lines.filter(line -> line.length() != 0)
                .map(line -> {
                    String[] eventData = line.split(";");
                    String[] parsedEventData = new String[eventData.length];
                    for (int i = 0; i < eventData.length; i++) {
                        parsedEventData[i] = eventData[i].split("=")[1];
                    }
                    return FootballMatchEvent.builder()
                            .code(Integer.parseInt(parsedEventData[0]))
                            .fromPlayer(parsedEventData[1])
                            .toPlayer(parsedEventData[2])
                            .eventTime(parsedEventData[3])
                            .stadion(parsedEventData[4])
                            .startTime(parsedEventData[5]).build();
                });
        return sqlContext.createDataFrame(footballMatchEventRDD, FootballMatchEvent.class);
    }

}
