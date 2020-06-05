package org.example.web.rest;


import org.example.backend.service.CountryService;
import org.example.xsd.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @GetMapping("/{name}")
    public Country getCountryByName(@PathVariable String name) {
        return countryService.findCountryByName(name);
    }

    @PostMapping("/save")
    public Country saveCountry(@RequestBody Country country) {
        countryService.addCountry(country);
        return country;
    }

    @PutMapping("/update")
    public Country updateCountry(@RequestBody Country country) {
        countryService.updateCountry(country);
        return country;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCountry(@PathVariable Integer id) {
        countryService.deleteCountry(id);
    }

}
