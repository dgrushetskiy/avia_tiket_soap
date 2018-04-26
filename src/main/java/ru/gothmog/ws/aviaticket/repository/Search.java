package ru.gothmog.ws.aviaticket.repository;

import ru.gothmog.ws.aviaticket.entity.Flight;
import ru.gothmog.ws.aviaticket.entity.spr.City;

import java.util.Date;
import java.util.List;

public interface Search {

    List<Flight> searchFlight(Date date, City cityFrom, City cityTo);

    List<City> getAllCities();
}
