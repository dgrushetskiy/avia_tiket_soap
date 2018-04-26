package ru.gothmog.ws.aviaticket.repository.impl;

import ru.gothmog.ws.aviaticket.entity.spr.City;
import ru.gothmog.ws.aviaticket.repository.CityDao;

import java.util.List;

public class CityDaoImpl extends CrudDaoImpl<City> implements CityDao{
    public CityDaoImpl(Class<City> entityClass) {
        super(entityClass);
    }
}
