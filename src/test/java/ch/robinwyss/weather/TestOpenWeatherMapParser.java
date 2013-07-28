package ch.robinwyss.weather;

import ch.robinwyss.data.weather.openweather.Condition;
import junit.framework.Assert;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by robin
 * Date: 28.07.13 Time: 15:30
 */
public class TestOpenWeatherMapParser {

    @Test
    public void testOpenWeatherParser() throws IOException {
        String jsonData = "{\"coord\":{\"lon\":139,\"lat\":35},\"sys\":{\"country\":\"JP\",\"sunrise\":1374954641,\"sunset\":1375005019},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"base\":\"gdps stations\",\"main\":{\"temp\":301.48,\"pressure\":1006,\"temp_min\":301.48,\"temp_max\":301.48,\"humidity\":98},\"wind\":{\"speed\":1.41,\"deg\":267.501},\"rain\":{\"3h\":0},\"clouds\":{\"all\":32},\"dt\":1375017467,\"id\":1851632,\"name\":\"Shuzenji\",\"cod\":200}";
        JsonParser jsonParser = new JsonFactory().createJsonParser(jsonData);
         // advance stream to START_ARRAY first:
        JsonToken jsonToken = jsonParser.nextToken();
        System.out.println(jsonToken);
        ObjectMapper mapper = new ObjectMapper();
        Condition condition = mapper.readValue(jsonParser, Condition.class);
        Assert.assertEquals(condition.getCoord().getLat(), 35);
        Assert.assertEquals(condition.getCoord().getLon(), 139);
        System.out.println(condition);
        // and then each time, advance to opening START_OBJECT
//        while (jp.nextToken() == JsonToken.START_OBJECT)) {
//
//        }

    }
}
