package com.cognizant.mockito;

public interface ExternalApi {

    String getData();

    String getDataByCountry(String country);

    void logRequest(String request);

    void logResponse(String response);
}