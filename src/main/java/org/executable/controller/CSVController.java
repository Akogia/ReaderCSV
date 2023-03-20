package org.executable.controller;

import org.executable.printer.Printer;
import org.executable.reader.CSVReader;
import org.executable.service.CSVService;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

public class CSVController {
    static Logger log = Logger.getLogger(CSVController.class.getName());
    private static int pointer = 1;

    public static void CSVMain(String input, String folderPath){
        File folder = new File(folderPath);
        File[] listFiles = folder.listFiles();

        log.info("CSV Main");
        switch (input){
            case "F":
                System.out.println("First Page");
                pointer = CSVService.firstPage(listFiles, pointer);
                break;
            case "P":
                System.out.println("Previous Page");
                pointer = CSVService.previousPage(listFiles, pointer);
                break;
            case "N":
                System.out.println("Next Page");
                pointer = CSVService.nextPage(listFiles, pointer);
                break;
            case "L":
                System.out.println("Last Page");
                pointer = CSVService.lastPage(listFiles, pointer);
                break;
            case "J":
                System.out.println("Jump Page");
                pointer = CSVService.jumpPage(listFiles, pointer);
                break;
            case "S":
                System.out.println("Sort");
                break;
            default:
                System.out.println("Unknown input: " + input + ", please try again");
                break;
        }

    }
}
