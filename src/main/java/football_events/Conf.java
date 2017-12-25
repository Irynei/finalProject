package football_events;

import football_events.bpp.AutowiredBroadcastBPP;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * Created by irko on 25.12.17.
 */

@Configuration
@ComponentScan
@PropertySource("classpath:main.properties")
@EnableAspectJAutoProxy
public class Conf {

    @Autowired
    private SparkConf sparkConf;

    @Bean
    public JavaSparkContext sc(){
        return new JavaSparkContext(sparkConf);
    }

    @Bean
    public SQLContext sqlContext(){
        return new SQLContext(sc());
    }

    @Bean
    public AutowiredBroadcastBPP autowiredBroadcastBPP() {
        return new AutowiredBroadcastBPP();
    }

}
