package org.example.backend.service.impl;

import org.example.backend.dao.CountryDao;
import org.example.backend.service.CountryService;
import org.example.xsd.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    @Override
    public Country findCountryByName(String name) {
        return countryDao.findCountryByName(name);
    }

    @Override
    public List<Country> findAll() {
        return countryDao.findAll();
    }

    @Override
    public void deleteCountry(Integer id) {
        countryDao.deleteCountry(id);
    }

    @Override
    public void updateCountry(Country country) {
        countryDao.updateCountry(country);
    }

    @Override
    public void addCountry(Country country) {
        countryDao.addCountry(country);
    }
}
