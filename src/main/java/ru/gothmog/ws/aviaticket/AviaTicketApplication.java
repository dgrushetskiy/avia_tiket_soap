package ru.gothmog.ws.aviaticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.gothmog.ws.aviaticket.entity.spr.City;
import ru.gothmog.ws.aviaticket.repository.CityDao;
import ru.gothmog.ws.aviaticket.repository.impl.CityDaoImpl;

@SpringBootApplication
public class AviaTicketApplication {
    public static void main(String[] args) {
        SpringApplication.run(AviaTicketApplication.class, args);
    }
    @Bean
    public CityDao cityDao(){
        return new CityDaoImpl(City.class);
    }
}
