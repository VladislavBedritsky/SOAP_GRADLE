package org.example.backend.service;

import org.example.xsd.country.Country;

import java.util.List;

public interface CountryService {

    Country findCountryByName (String name);

    List<Country> findAll();

    void deleteCountry(Integer id);

    void updateCountry(Country country);

    void addCountry(Country country);
}
