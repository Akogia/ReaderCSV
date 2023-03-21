package org.executable.controller;

import org.executable.service.CSVService;

import java.io.File;

public class CSVController {

    public static void CSVMain(String input, String folderPath){
        File folder = new File(folderPath);
        File[] listFiles = folder.listFiles();

        switch (input){
            case "F":
                CSVService.firstPage(listFiles);
                break;
            case "P":
                CSVService.previousPage(listFiles);
                break;
            case "N":
                CSVService.nextPage(listFiles);
                break;
            case "L":
                CSVService.lastPage(listFiles);
                break;
            case "J":
                CSVService.jumpPage(listFiles);
                break;
            case "S":
                CSVService.sortPage(listFiles);
                break;
            default:
                System.out.println("Unknown input: " + input + ", please try again");
                break;
        }

    }
}
