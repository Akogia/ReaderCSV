package org.executable.service;

import org.executable.common.CSVPrinter;
import org.executable.common.CSVReader;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CSVService {

        private static int pointer = 1;

        public static int firstPage(File[] files){
                pointer = 1;
                readFileAndPrint(files[pointer-1].toString(), pointer, String.valueOf(files.length));
                return pointer;
        }

        public static int previousPage(File[] files){
                if(pointer == 1){
                        pointer = files.length;
                } else {
                        pointer -= 1;
                }
                readFileAndPrint(files[pointer-1].toString(), pointer, String.valueOf(files.length));
                return pointer;
        }

        public static int nextPage(File[] files){
                pointer += 1;
                readFileAndPrint(files[pointer-1].toString(), pointer, String.valueOf(files.length));
                return pointer;
        }

        public static int lastPage(File[] files){
                pointer = files.length;
                readFileAndPrint(files[pointer-1].toString(), pointer, String.valueOf(files.length));
                return pointer;
        }

        public static int jumpPage(File[] files){
                try{
                        Scanner input = new Scanner(System.in);
                        pointer = input.nextInt();
                        readFileAndPrint(files[pointer-1].toString(), pointer, String.valueOf(files.length));
                }catch (Exception e){
                        System.out.println("false input");
                }
                return pointer;
        }

        public static void sortPage(File[] files){
                try{
                        Scanner sortColumn = new Scanner(System.in);
                        List<String[]> unsorted = CSVReader.readDataFromCustomSeparator(files[pointer-1].toString());
                        String sort = sortColumn.nextLine();

                        int columnInt = 0;
                        for(String column : unsorted.get(0)){

                                if(column.equals(sort)){
                                        sortData(unsorted.subList(1, unsorted.size()), columnInt);
                                        CSVPrinter.printAllData(unsorted, String.valueOf(pointer), String.valueOf(files.length));
                                }
                                columnInt += 1;
                        }
                }catch (Exception e){
                        System.out.println("Invalid column");
                }
        }

        private static void sortData(List<String[]> unsortedData, int columnInt){
                Collections.sort(unsortedData, new Comparator<String[]>() {
                        @Override
                        public int compare(String[] o1, String[] o2) {
                                return o1[columnInt].compareTo(o2[columnInt]);
                        }
                });
        }

        private static void readFileAndPrint(String filePath, int pointer, String maxFileLength){
                List<String[]> resultData  = CSVReader.readDataFromCustomSeparator(filePath);
                CSVPrinter.printAllData(resultData, String.valueOf(pointer), maxFileLength);
        }
}
