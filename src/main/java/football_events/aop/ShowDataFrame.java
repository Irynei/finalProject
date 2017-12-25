package football_events.aop;
import org.apache.spark.sql.DataFrame;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import static football_events.configs.Const.DEV;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by irko on 25.12.17.
 */

@Component
@Aspect
@Profile(DEV)
public class ShowDataFrame {
    @Before("@annotation(football_events.annotations.ShowDataFrameInTheBeginning)")
    public void showDataFrameInTheBeginningOf(JoinPoint jp) {
        DataFrame dataFrame = (DataFrame) jp.getArgs()[0];
        String className = jp.getTarget().getClass().getSimpleName();
        String methodName = jp.getSignature().getName();
        log.println("**Aspect ShowDataFrameInTheBeginning is working   " + className + "." + methodName);
        log.println("class: " + jp.getTarget().getClass().getSimpleName());
        dataFrame.show();
        log.println("**Aspect ShowDataFrameInTheBeginning end his work   " + className + "." + methodName);
    }
}
