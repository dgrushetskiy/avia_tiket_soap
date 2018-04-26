package ru.gothmog.ws.aviaticket.repository;

import org.hibernate.Session;

public interface Dao {
    /**
     * @return current Hibernate Session
     */
    Session getSession();
}
