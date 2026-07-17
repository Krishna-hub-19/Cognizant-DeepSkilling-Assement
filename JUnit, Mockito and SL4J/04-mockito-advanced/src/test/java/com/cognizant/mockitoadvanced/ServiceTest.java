package com.cognizant.mockitoadvanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ServiceTest {

    @Test
    void testServiceWithMockRepository() {

        // Arrange
        Repository mockRepository = mock(Repository.class);

        when(mockRepository.getData())
                .thenReturn("Mock Data");

        Service service = new Service(mockRepository);

        // Act
        String result = service.processData();

        // Assert
        assertEquals("Processed Mock Data", result);

        verify(mockRepository).getData();
    }
}