package org.executable.common;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;

public class CSVReader {

    public static List<String[]> readDataFromCustomSeparator(String file)
    {
        try (FileReader filereader = new FileReader(file)){
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

            // TODO parsen und readen separieren
            com.opencsv.CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withCSVParser(parser)
                .build();
            return csvReader.readAll();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
