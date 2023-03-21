package org.executable;

import org.executable.controller.CSVController;
import org.executable.printer.CSVPrinter;
import org.executable.reader.CSVReader;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


public class Main {
    static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        // Print for the first time, the first CSV File
        File folder = new File(args[1]);
        File[] listFiles = folder.listFiles();
        List<String[]> resultData  = CSVReader.readDataFromCustomSeparator(listFiles[0].toString());
        CSVPrinter.printAllData(resultData, "1", String.valueOf(listFiles.length));


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