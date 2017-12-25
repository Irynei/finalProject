package football_events;

import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by irko on 25.12.17.
 */

@Component
public class FootballConfig implements Serializable {

    @Getter
    private Map<String, String> playerToCountry = new HashMap<>();

    @Getter
    private Map<Integer, String> descriptionToEventCode = new HashMap<>();

    @Value("${codesPropertiesPath}")
    private String codesPath;

    @Value("${teamsPropertiesPath}")
    private String teamsPath;

    @PostConstruct
    @SneakyThrows
    public void initPlayerByCountryMap(){
        Properties teams = PropertiesLoaderUtils.loadAllProperties(teamsPath);
        teams.stringPropertyNames().stream().forEach(country ->
                Arrays.stream(teams.getProperty(country).split(","))
                .forEach(player -> playerToCountry.put(player, country)));
    }

    @PostConstruct
    @SneakyThrows
    public void initDescriptionByEvent() {
        Properties codes = PropertiesLoaderUtils.loadAllProperties(codesPath);
        codes.stringPropertyNames().stream().forEach(pair -> descriptionToEventCode.put(Integer.parseInt(pair), codes.getProperty(pair)));
    }


}
