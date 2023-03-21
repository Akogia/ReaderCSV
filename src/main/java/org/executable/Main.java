package org.executable;

import org.executable.controller.CSVController;
import org.executable.common.CSVPrinter;
import org.executable.common.CSVReader;
import org.executable.service.CSVService;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


public class Main {
    static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        // Print for the first time, the first CSV File
        // args is the path to the resource folder
        File folder = new File(args[1]);
        File[] listFiles = folder.listFiles();
        CSVService.start(listFiles);


        Scanner scanner = new Scanner(System.in);
        boolean looping = true;
        while(looping){

            String input = scanner.nextLine();
            CSVController.CSVMain(input, args[1]);
            if("E".equals(input)){
                looping = false;
            }
        }
        scanner.close();
    }
}