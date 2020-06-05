package org.example.consumer.client;

import org.example.xsd.country.GetCountryByNameRequest;
import org.example.xsd.country.GetCountryByNameResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryClient.class);

    public GetCountryByNameResponse getCountryByName(String country) {

        GetCountryByNameRequest request = new GetCountryByNameRequest();
        request.setName(country);

        LOGGER.info("Requesting location for " + country);

        GetCountryByNameResponse response = (GetCountryByNameResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
                        new SoapActionCallback(
                                "http://example.org/xsd/country"));

        return response;
    }

}
