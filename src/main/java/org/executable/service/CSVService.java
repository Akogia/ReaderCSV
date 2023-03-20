package org.executable.service;

import org.executable.printer.Printer;
import org.executable.reader.CSVReader;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class CSVService {

        public static int firstPage(File[] files, int pointer){
                pointer = 1;
                readFileAndPrint(files[pointer-1].toString(), pointer, String.valueOf(files.length));
                return pointer;
        }

        public static int previousPage(File[] files, int pointer){
                if(pointer == 1){
                        pointer = files.length;
                } else {
                        pointer -= 1;
                }
                readFileAndPrint(files[pointer-1].toString(), pointer, String.valueOf(files.length));
                return pointer;
        }

        public static int nextPage(File[] files, int pointer){
                pointer += 1;
                readFileAndPrint(files[pointer-1].toString(), pointer, String.valueOf(files.length));
                return pointer;
        }

        public static int lastPage(File[] files, int pointer){
                pointer = files.length;
                readFileAndPrint(files[pointer-1].toString(), pointer, String.valueOf(files.length));
                return pointer;
        }

        public static int jumpPage(File[] files, int pointer){
                try{
                        Scanner input = new Scanner(System.in);
                        pointer = input.nextInt();
                        readFileAndPrint(files[pointer-1].toString(), pointer, String.valueOf(files.length));
                }catch (Exception e){
                        System.out.println("false input");
                }
                return pointer;
        }

        private static void readFileAndPrint(String filePath, int pointer, String maxFileLength){
                List<String[]> resultData  = CSVReader.readDataFromCustomSeparator(filePath);
                Printer.printAllData(resultData, String.valueOf(pointer), maxFileLength);
        }
}
