package org.executable.printer;

import java.util.List;

public class Printer {

    public static void printAllData(List<String[]> data){

        int[] maxRowLength = getMaxRowLength(data);
        // TODO printHeader , printSeparator
        buildHeader(maxRowLength, data.get(0));
        buildSeparator(maxRowLength);
        buildInfo(maxRowLength, data.subList(1, data.size()));
        // TODO auslagern
        System.out.println("F)irst page, P)revious page, N)ext page, L)ast page, E)xit");
    }


    private static int[] getMaxRowLength(List<String[]> data) {
        int[] result = new int[data.get(0).length];

        for(String[] row : data){
            for(int i = 0; i< row.length; i++){
                if(row[i].length() > result[i]){
                    result[i] = row[i].length();
                }
            }
        }
        return result;
    }

    private static void buildInfo(int[] result, List<String[]> data) {
        for(String[] row: data){
            stringBuilderInfo(result, row);
        }
    }

    private static void stringBuilderInfo(int[] result, String[] row) {
        StringBuilder info = new StringBuilder();
        for(int i = 0; i < result.length; i++){
            info.append(row[i]);
            appendWhiteSpace(info, result[i]-row[i].length());
            info.append("|");
        }
        System.out.println(info);
    }

    private static void buildSeparator(int[] result) {
        StringBuilder secondRow = new StringBuilder();
        for(int i : result){
            secondRow.append("-".repeat(Math.max(0, i)));
            secondRow.append("+");
        }
        System.out.println(secondRow);
    }

    private static void buildHeader(int[] result, String[] data) {
        stringBuilderInfo(result, data);
    }

    private static void appendWhiteSpace(StringBuilder row, int counter){
        row.append(" ".repeat(Math.max(0, counter)));
    }
}
