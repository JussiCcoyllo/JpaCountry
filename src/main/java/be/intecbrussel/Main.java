package be.intecbrussel;


import be.intecbrussel.model.Country;
import be.intecbrussel.model.President;
import be.intecbrussel.service.CountryService;

import java.util.Optional;
import java.util.zip.CheckedOutputStream;

public class Main {
    public static void main(String[] args) {
        //Creatr countries
        Country belgium = new Country("Belgium", 11000000);
        Country france = new Country("France", 60000000);
        Country peru = new Country("Peru", 33000000);

        //Service handless the logic
        CountryService cs = new CountryService();

        //Saves countries to database
        cs.createCountry(belgium);
        cs.createCountry(france);
        cs.createCountry(peru);

        //Read countries from DB
        Optional<Country> dbCountry = cs.readCountry("belgium");
        if (dbCountry.isPresent()) {
            System.out.println(dbCountry);
        } else {
            System.out.println("No country found!");
        }

        //Delete country from DB
        cs.deleteCountry("France");
    }
}
