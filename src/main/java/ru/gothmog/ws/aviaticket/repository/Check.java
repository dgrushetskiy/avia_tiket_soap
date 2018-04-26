package ru.gothmog.ws.aviaticket.repository;

import ru.gothmog.ws.aviaticket.entity.Reservation;

import java.util.Date;

public interface Check{

    Reservation checkReservationByCode(String code);

    Reservation checkReservationByDateReserv(String docNumber);

    Reservation checkReservationByDateReserv(Date date);

    Reservation checkReservationByFamilyName(String familyName);
}
