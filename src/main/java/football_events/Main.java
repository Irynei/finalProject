package football_events;

import football_events.enrichers.TeamEnricher;
import football_events.validators.PlayersValidator;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * Created by irko on 25.12.17.
 */

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        ProcessData processData = context.getBean(ProcessData.class);
        DataFrame data = processData.runAll();
        data.show();
    }
}
