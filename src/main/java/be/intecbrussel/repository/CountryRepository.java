package be.intecbrussel.repository;

import be.intecbrussel.model.Country;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class CountryRepository {
    //Connect to the DB

    //If you modify the DB
    //1. Begin transaction
    //2. Do DB stuff
    //3. Commit transaction
    //4. Return object if needed

    public void createCountry(EntityManager em, Country country) {
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
       // em.getTransaction().rollback(); other method
    }

    //If you only read from DB
    //1. Read from DB
    //2. Return object

    public Optional<Country> readCountry(EntityManager em, String name) {
        Country country = em.find(Country.class, name);
        return Optional.ofNullable(country); //
    }
    public void deleteCountry(EntityManager em, Country country) {
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit(); //do it
    }
    public void updateCountry(EntityManager em, Country country) {
        em.getTransaction().begin();
        em.merge(country);
        em.getTransaction().commit();
    }
}
