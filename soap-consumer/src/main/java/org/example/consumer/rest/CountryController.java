package org.example.consumer.rest;

import org.example.consumer.client.CountryClient;
import org.example.xsd.country.GetCountryByNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryClient countryClient;

    @GetMapping
    public GetCountryByNameResponse getCountryByName(@RequestParam String name) {
        return countryClient.getCountryByName(name);
    }

}
