package football_events.configs;

import org.apache.spark.SparkConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static football_events.configs.Const.PROD;

/**
 * Created by irko on 25.12.17.
 * Can set prod specific configuration here
 */
@Profile(PROD)
@Configuration
public class ProdConf {
    @Bean
    public SparkConf sparkConf(){
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("football_events");
        return sparkConf;
    }

}
