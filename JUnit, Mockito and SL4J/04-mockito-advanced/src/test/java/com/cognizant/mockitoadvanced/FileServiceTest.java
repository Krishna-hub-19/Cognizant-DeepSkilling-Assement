package com.cognizant.mockitoadvanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FileServiceTest {

    @Test
    void testServiceWithMockFileIO() {

        // Arrange
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        when(mockFileReader.read())
                .thenReturn("Mock File Content");

        FileService fileService = new FileService(
                mockFileReader,
                mockFileWriter
        );

        // Act
        String result = fileService.processFile();

        // Assert
        assertEquals("Processed Mock File Content", result);

        verify(mockFileReader).read();

        verify(mockFileWriter)
                .write("Processed Mock File Content");
    }
}