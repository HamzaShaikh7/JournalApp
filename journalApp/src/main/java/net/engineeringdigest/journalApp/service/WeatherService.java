package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.cashe.AppCashe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class WeatherService
{

//    Used in hardcord.
//    private static final String apiKey = "b6cc20a9661d46bea0740761f80780bc";



//    using through application properties.
    @Value("${weather.api.key}")
    private String apiKey;


    private static final String API = "http://api.weatherstack.com/current?access_key=<api_key>&query=<city>";


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCashe appCashe;

    public WeatherResponse getWeather(String city){
        String finalAPI = API.replace("<api_key>",apiKey).replace("<city>",city);
//        String finalAPI = appCashe.APP_CASHE.get("weather_api").replace("<api_key>",apiKey).replace("<city>",city);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}
