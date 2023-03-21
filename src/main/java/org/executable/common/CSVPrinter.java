package org.executable.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVPrinter {

    public static void printAllData(List<String[]> data, String pointer, String maxPage){
        int[] maxRowLength = getMaxRowLength(data);
        buildHeader(maxRowLength, data.get(0));
        buildSeparator(maxRowLength);
        buildInfo(maxRowLength, data.subList(1, data.size()));
        printPageNumber(pointer, maxPage);
        printLegend();
    }


    private static int[] getMaxRowLength(List<String[]> data) {
        int[] result = new int[data.get(0).length + 1];
        result[0] = 3;
        for(String[] row : data){
            for(int i = 0; i< row.length; i++){
                if(row[i].length() > result[i+1]){
                    result[i+1] = row[i].length();
                }
            }
        }
        return result;
    }

    private static void buildInfo(int[] result, List<String[]> data) {
        for(int i = 0; i < data.size(); i++){
            List<String> infoList = new ArrayList<>(Arrays.stream(data.get(i)).toList());
            infoList.add(0, String.valueOf(i));
            stringBuilderInfo(result, infoList);
        }
    }

    private static void stringBuilderInfo(int[] result, List<String> row) {
        StringBuilder info = new StringBuilder();
        for(int i = 0; i < result.length; i++){
            info.append(row.get(i));
            appendWhiteSpace(info, result[i]-row.get(i).length());
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
        List<String> numberHeader = new ArrayList<>(Arrays.stream(data).toList());
        numberHeader.add(0,"No.");
        stringBuilderInfo(result, numberHeader);
    }

    private static void appendWhiteSpace(StringBuilder row, int counter){
        row.append(" ".repeat(Math.max(0, counter)));
    }

    private static void printPageNumber(String pointer, String maxPage){
        System.out.println("Page " + pointer  + " of " + maxPage);
    }

    private static void printLegend(){
        System.out.println("F)irst page, P)revious page, N)ext page, L)ast page, J)ump to page, S)ort, E)xit");
    }
}
