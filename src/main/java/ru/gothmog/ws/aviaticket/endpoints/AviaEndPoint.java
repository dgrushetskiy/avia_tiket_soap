package ru.gothmog.ws.aviaticket.endpoints;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.gothmog.avia_ws.gs_ws.City;
import ru.gothmog.avia_ws.gs_ws.GetAllCities;
import ru.gothmog.avia_ws.gs_ws.GetAllCitiesResponse;
import ru.gothmog.ws.aviaticket.service.CityService;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class AviaEndPoint {

    private static final String NAMESPACE_URI = "http://www.gothmog.ru/avia-ws";
    @Autowired
    private CityService cityService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCities")
    @ResponsePayload
    public GetAllCitiesResponse getAllCities(){
        GetAllCitiesResponse response = new GetAllCitiesResponse();
        List<City> cityList = new ArrayList<>();
        List<ru.gothmog.ws.aviaticket.entity.spr.City> cities = cityService.getAllCites();
        cities.forEach(city -> {
            City city1 = new City();
            city1.setId(city.getCityId());
            cityList.add(city1);
            BeanUtils.copyProperties(cities, cityList);
        });
        response.getReturn().addAll(cityList);
        return response;
    }


}
