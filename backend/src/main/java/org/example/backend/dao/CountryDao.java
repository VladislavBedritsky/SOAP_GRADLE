package org.example.backend.dao;

import org.example.xsd.country.Country;

public interface CountryDao {

    Country findCountryByName (String name);
}
