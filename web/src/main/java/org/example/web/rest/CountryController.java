package org.example.web.rest;


import org.example.xsd.country.Country;
import org.example.xsd.country.Currency;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping
    public Country getCountry() {
        Country country = new Country();
        country.setName("Russia");
        country.setCapital("Moscow");
        country.setCurrency(Currency.EUR);
        country.setPopulation(1000);
        return country;
    }

}
