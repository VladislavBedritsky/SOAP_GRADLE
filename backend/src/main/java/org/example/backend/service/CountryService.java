package org.example.backend.service;

import org.example.xsd.country.Country;

public interface CountryService {

    Country findCountryByName (String name);
}
