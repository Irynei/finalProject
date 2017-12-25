package football_events.annotations;

import football_events.listeners.Types;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by irko on 25.12.17.
 */

@Retention(RUNTIME)
@Component
public @interface RegisterUDF {
    Types returnType();
}
