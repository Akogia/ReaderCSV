package org.executable;

import org.executable.printer.Printer;
import org.executable.reader.CSVReader;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Main.class.getName());
        log.info("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = null;
        File folder = new File(args[1]);
        File[] list = folder.listFiles();
        List<String[]> resultData  = CSVReader.readDataFromCustomSeparator(list[0].toString());

        Printer.printAllData(resultData);

        while(!"end".equals(username)){
            username = scanner.nextLine();
            log.info("Your username is " + username);
        }
        scanner.close();
    }
}