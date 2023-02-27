package be.intecbrussel.repository;

import be.intecbrussel.model.Country;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class CountryRepository {
    //Connect to the DB
    public void createCountry(EntityManager em, Country country) {
        em.getTransaction().begin();

        em.persist(country);

        em.getTransaction().commit();
       // em.getTransaction().rollback(); other method
    }
    public Optional<Country> readCountry(EntityManager em, String name) {
        Country country = em.find(Country.class, name);
        return Optional.ofNullable(country);
    }
    public void deleteCountry(EntityManager em, Country country) {
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();
    }
}
