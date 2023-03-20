package org.executable;

import org.executable.controller.CSVController;
import org.executable.printer.Printer;
import org.executable.reader.CSVReader;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


public class Main {
    static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        while(exit){

            String input = scanner.nextLine();
            CSVController.CSVMain(input, args[1]);
            System.out.println("F)irst page, P)revious page, N)ext page, L)ast page, J)ump to page, S)ort, E)xit");
            if("E".equals(input)){
                exit = false;
            }
        }
        scanner.close();
    }
}