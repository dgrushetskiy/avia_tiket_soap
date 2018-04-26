package ru.gothmog.ws.aviaticket.repository;

import ru.gothmog.ws.aviaticket.entity.Flight;
import ru.gothmog.ws.aviaticket.entity.Passenger;
import ru.gothmog.ws.aviaticket.entity.spr.Place;

public interface Buy {

    boolean buyTicket(Flight flight, Place place, Passenger passenger, String addInfo);
}
