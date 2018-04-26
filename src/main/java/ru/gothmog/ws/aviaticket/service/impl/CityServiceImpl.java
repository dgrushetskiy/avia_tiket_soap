package ru.gothmog.ws.aviaticket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gothmog.ws.aviaticket.entity.spr.City;
import ru.gothmog.ws.aviaticket.repository.CityDao;
import ru.gothmog.ws.aviaticket.service.CityService;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;
    @Override
    public List<City> getAllCites() {
        return cityDao.getAllList();
    }
}
