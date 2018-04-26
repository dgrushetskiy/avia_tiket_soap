package ru.gothmog.ws.aviaticket.repository.impl;

import ru.gothmog.ws.aviaticket.entity.Reservation;
import ru.gothmog.ws.aviaticket.repository.Check;

import java.util.Date;

public class CheckImpl extends DaoImpl implements Check {

    @Override
    public Reservation checkReservationByCode(String code) {
        return null;
    }

    @Override
    public Reservation checkReservationByDateReserv(String docNumber) {
        return null;
    }

    @Override
    public Reservation checkReservationByDateReserv(Date date) {
        return null;
    }


    @Override
    public Reservation checkReservationByFamilyName(String familyName) {
        return null;
    }
}
