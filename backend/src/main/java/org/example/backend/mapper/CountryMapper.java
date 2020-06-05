package org.example.backend.mapper;

import org.example.xsd.country.Country;
import org.example.xsd.country.Currency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        Country country = new Country();

        country.setId(rs.getInt("id"));
        country.setName(rs.getString("name"));
        country.setPopulation(rs.getString("population"));
        country.setCapital(rs.getString("capital"));
        country.setCurrency(Currency.valueOf(rs.getString("currency")));

        return country;
    }
}
