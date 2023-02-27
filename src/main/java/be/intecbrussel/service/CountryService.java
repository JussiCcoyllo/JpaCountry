package be.intecbrussel.service;

import be.intecbrussel.connection.EntityManagerProvider;
import be.intecbrussel.model.Country;
import be.intecbrussel.repository.CountryRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class CountryService {
    private CountryRepository countryRepository = new CountryRepository();
    //1. Make an entity manager
    //2. Use the repository to do database things
    //3. Close the entity manager
    //4. Return an object if needed (optional)


    public void createCountry(Country country) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        countryRepository.createCountry(em, country);
        em.close();

        //CRUD operations  CREATE REATE UPDATE DELETE
    }

    public Optional<Country> readCountry(String name) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Optional<Country> optionalCountry = countryRepository.readCountry(em, name);
        em.close();
        return optionalCountry;
    }

    public void deleteCountry(String name) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Optional<Country> country = countryRepository.readCountry(em, name);

        if (country.isPresent()) {
            countryRepository.deleteCountry(em, country.get());
        }
        em.close();
    }
}


