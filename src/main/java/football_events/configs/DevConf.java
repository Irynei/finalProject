package football_events.configs;

import org.apache.spark.SparkConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static football_events.configs.Const.DEV;

/**
 * Created by irko on 25.12.17.
 */

@Profile(DEV)
@Configuration
public class DevConf {
    @Bean
    public SparkConf sparkConf(){
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("football_events");
        sparkConf.setMaster("local[*]");
        return sparkConf;
    }
}
