package org.executable.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CSVPrinterTest {



    @Test
    void printAllData(){
        // Arrange
        List<String[]> csvData = new ArrayList<>();
        csvData.add(new String[]{"name", "age", "city"});
        csvData.add(new String[]{"Peter", "42", "New York"});
        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
        byte[] logging = outSpy.toByteArray();
        // Act
        CSVPrinter.printAllData(csvData,"1","2");

        // Assert
        System.out.println(new String(logging));
    }
}