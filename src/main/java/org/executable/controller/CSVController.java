package org.executable.controller;

import org.executable.service.CSVService;

import java.io.File;

public class CSVController {
    private static int pointer = 1;

    public static void CSVMain(String input, String folderPath){
        File folder = new File(folderPath);
        File[] listFiles = folder.listFiles();

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
                CSVService.sortPage(listFiles, pointer);
                break;
            default:
                System.out.println("Unknown input: " + input + ", please try again");
                break;
        }

    }
}
