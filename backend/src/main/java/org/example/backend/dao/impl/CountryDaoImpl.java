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

@Repository
@PropertySource("classpath:sql-query.properties")
public class CountryDaoImpl implements CountryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Value("${db.countries.findCountryByName}")
    private String findCountryByNameQuery;

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


}
