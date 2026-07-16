package com.cognizant.mockito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    void testExternalApi() {

        // Arrange
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        // Act
        String result = service.fetchData();

        // Assert
        assertEquals("Mock Data", result);
    }

    @Test
    void testVerifyInteraction() {

        // Arrange
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        // Act
        service.fetchData();

        // Assert
        verify(mockApi).getData();
    }

    @Test
    void testVerifyTwoCalls() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        service.fetchData();
        service.fetchData();

        verify(mockApi, times(2)).getData();
    }

    @Test
    void testAnyStringMatcher() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getDataByCountry(anyString()))
                .thenReturn("Country Data");

        MyService service = new MyService(mockApi);

        String result = service.fetchCountryData("India");

        assertEquals("Country Data", result);

        verify(mockApi).getDataByCountry(anyString());
    }

    @Test
    void testExactArgument() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getDataByCountry(eq("India")))
                .thenReturn("Indian Data");

        MyService service = new MyService(mockApi);

        String result = service.fetchCountryData("India");

        assertEquals("Indian Data", result);

        verify(mockApi).getDataByCountry(eq("India"));
    }

    @Test
    void testDifferentCountry() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getDataByCountry(anyString()))
                .thenReturn("Country Data");

        MyService service = new MyService(mockApi);

        service.fetchCountryData("USA");

        verify(mockApi).getDataByCountry("USA");
    }
}