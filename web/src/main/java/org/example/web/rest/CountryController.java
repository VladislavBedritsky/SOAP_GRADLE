package org.example.web.rest;


import org.example.backend.service.CountryService;
import org.example.xsd.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public Country getCountryByName(@RequestParam String name) {
        return countryService.findCountryByName(name);
    }

}
