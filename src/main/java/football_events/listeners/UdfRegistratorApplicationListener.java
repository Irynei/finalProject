package football_events.listeners;

import football_events.annotations.RegisterUDF;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.api.java.UDF1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by irko on 25.12.17.
 */

@Component
public class UdfRegistratorApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private SQLContext sqlContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Collection<Object> udfObjects = context.getBeansWithAnnotation(RegisterUDF.class).values();
        for (Object udfObject : udfObjects) {

            Types returnType = udfObject.getClass().getAnnotation(RegisterUDF.class).returnType();
            sqlContext.udf().register(udfObject.getClass().getName(),
                    (UDF1<?, ?>) udfObject,
                    Types.convertToSparkType(returnType));
        }
    }
}

