package com.forecast.weatherApi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.forecast.weatherApi.model.WeatherAverage;
import com.forecast.weatherApi.model.WeatherMap;
import com.forecast.weatherApi.model.WeatherMapTime;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import springfox.documentation.spring.web.json.Json;


@Service
public class WeatherService {
    
    @Value("${id}")
    private  String API_ID;
    @Value("${url}")
    private  String URI;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<?> calculateAverageWeather(String city) {
        List<WeatherAverage> result = new ArrayList<WeatherAverage>();
        
		try {
			WeatherMap weatherMap = this.restTemplate.getForObject(this.url(city), WeatherMap.class);

			for (LocalDate date = LocalDate.now().plusDays(1); date
					.isBefore(LocalDate.now().plusDays(4)); date = date.plusDays(1)) {
				final LocalDate ref = date;
				List<WeatherMapTime> weatherMapTimeList = weatherMap.getList().stream()
						.filter(x -> x.getDt().toLocalDate().equals(ref)).collect(Collectors.toList());
				if (!CollectionUtils.isEmpty(weatherMapTimeList)) {
					result.add(this.weatherAverage(weatherMapTimeList));
				}

			}
		} catch (HttpClientErrorException e) {
            return new ResponseEntity<>(new Json(e.getResponseBodyAsString()), e.getStatusCode());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private WeatherAverage weatherAverage(List<WeatherMapTime> list) {
        WeatherAverage result = new WeatherAverage();

        for (WeatherMapTime item : list) {
            result.setDate(item.getDt().toLocalDate());
            result.addMap(item);
        }

        result.totalizer();

        return result;
    }

    private String url(String city) {
        return String.format(URI.concat("?q=%s").concat("&appid=%s").concat("&units=metric"), city, API_ID);
    }
}
