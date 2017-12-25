package football_events;

import lombok.Builder;
import lombok.Data;

/**
 * Created by irko on 25.12.17.
 */

@Data
@Builder
public class FootballMatchEvent {
    private int code;
    private String fromPlayer;
    private String toPlayer;
    private String eventTime;
    private String stadion;
    private String startTime;
}
