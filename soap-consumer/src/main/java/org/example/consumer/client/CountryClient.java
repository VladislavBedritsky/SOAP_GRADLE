package org.example.consumer.client;

import org.example.xsd.country.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryClient.class);

    public GetCountryByNameResponse getCountryByName(String country) {

        GetCountryByNameRequest request = new GetCountryByNameRequest();
        request.setName(country);

        LOGGER.info("Requesting location for " + country);

        GetCountryByNameResponse response = (GetCountryByNameResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request);

        return response;
    }

    public GetAllCountriesResponse getAllCountries() {

        GetAllCountriesRequest request = new GetAllCountriesRequest();
        LOGGER.info("Request is {}", request);

        return (GetAllCountriesResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request);

    }

    public void deleteCountry(Integer id) {
        GetDeleteCountryRequest request = new GetDeleteCountryRequest();
        request.setId(id);
        LOGGER.info("Request is {}", request);

        getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request);
    }

    public void updateCountry(Country country) {
        GetUpdateCountryRequest request = new GetUpdateCountryRequest();
        request.setCountry(country);
        LOGGER.info("Request is {}", request);

        getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request);
    }

    public void saveCountry(Country country) {
        GetAddCountryRequest request = new GetAddCountryRequest();
        request.setCountry(country);
        LOGGER.info("Request is {}", request);

        getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request);
    }

}
