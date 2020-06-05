package org.example.soap.endpoint;

import org.example.backend.service.CountryService;
import org.example.xsd.country.GetCountryByNameRequest;
import org.example.xsd.country.GetCountryByNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndPoint {

    private static final String NAMESPACE_URI = "http://example.org/xsd/country";

    @Autowired
    private CountryService countryService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryByNameRequest")
    @ResponsePayload
    public GetCountryByNameResponse getCountryByName(@RequestPayload GetCountryByNameRequest request) {
        GetCountryByNameResponse response = new GetCountryByNameResponse();
        response.setCountry(countryService.findCountryByName(request.getName()));
        return response;
    }

}
