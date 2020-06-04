package org.example.backend.dao.impl;

import org.example.backend.dao.CountryDao;
import org.example.xsd.country.Country;
import org.example.xsd.country.Currency;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {

    private static final List<Country> countries = new ArrayList<Country>();

    public CountryDaoImpl() {
        Country spain = new Country();
        spain.setId(1);
        spain.setName("Russia");
        spain.setCapital("Moscow");
        spain.setCurrency(Currency.RUB);
        spain.setPopulation("134");

        countries.add(spain);

        Country poland = new Country();
        poland.setId(2);
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation("83");

        countries.add(poland);
    }

    @Override
    public Country findCountryByName (String name) {
        Assert.notNull(name);

        Country result = null;

        for (Country country : countries) {
            if (name.equals(country.getName())) {
                result = country;
            }
        }

        return result;
    }

}
