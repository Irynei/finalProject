package football_events;

import football_events.businesslogic.ProcessData;
import org.apache.spark.sql.DataFrame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
