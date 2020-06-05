package org.example.consumer.rest;

import org.example.consumer.client.CountryClient;
import org.example.xsd.country.Country;
import org.example.xsd.country.GetAllCountriesResponse;
import org.example.xsd.country.GetCountryByNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryClient countryClient;

    @GetMapping
    public GetAllCountriesResponse findAll() {
        return countryClient.getAllCountries();
    }

    @GetMapping("/{name}")
    public GetCountryByNameResponse getCountryByName(@PathVariable String name) {
        return countryClient.getCountryByName(name);
    }

    @PostMapping("/save")
    public Country saveCountry(@RequestBody Country country) {
        countryClient.saveCountry(country);
        return country;
    }

    @PutMapping("/update")
    public Country updateCountry(@RequestBody Country country) {
        countryClient.updateCountry(country);
        return country;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCountry(@PathVariable Integer id) {
        countryClient.deleteCountry(id);
    }


}
