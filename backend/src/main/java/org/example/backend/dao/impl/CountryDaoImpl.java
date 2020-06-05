package org.example.backend.dao.impl;

import org.example.backend.dao.CountryDao;
import org.example.backend.mapper.CountryMapper;
import org.example.xsd.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@PropertySource("classpath:sql-query.properties")
public class CountryDaoImpl implements CountryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Value("${db.countries.findCountryByName}")
    private String findCountryByNameQuery;
    @Value("${db.countries.findAll}")
    private String findAllCountriesQuery;
    @Value("${db.countries.deleteCountryById}")
    private String deleteCountryByIdQuery;
    @Value("${db.countries.updateCountryById}")
    private String updateCountryByIdQuery;
    @Value("${db.countries.addCountry}")
    private String addCountryQuery;


    @Override
    public Country findCountryByName(String name) {
        Country country = new Country();
        try{
            country = jdbcTemplate.queryForObject(findCountryByNameQuery, new CountryMapper(), name);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();
        try{
            countries = jdbcTemplate.query(findAllCountriesQuery, new CountryMapper());
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public void deleteCountry(Integer id) {
        jdbcTemplate.update(deleteCountryByIdQuery, id);
    }

    @Override
    public void updateCountry(Country country) {
        jdbcTemplate.update(
                updateCountryByIdQuery,
                country.getName(), country.getPopulation(), country.getCapital(),
                country.getCurrency().toString(), country.getId()
        );
    }

    @Override
    public void addCountry(Country country) {
        jdbcTemplate.update(
                addCountryQuery,
                country.getName(), country.getPopulation(),
                country.getCapital(), country.getCurrency().toString()
        );
    }


}
