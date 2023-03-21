package org.executable.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToDictionary {

    public Map<String, String> mapString(String input) {
        String[] strings = splitString(input);
        List<String[]> stringList = splitKeyValuePair(strings);
        return mapStringList(stringList);
    }

    private Map<String, String> mapStringList(List<String[]> stringList) {
        Map<String, String> result = new HashMap<>();
        for(String[] strings : stringList){
            if("".equals(strings[0]) && strings.length != 1){
                throw new RuntimeException();
            }
            // empty String no mapping
            if("".equals(strings[0])){
                continue;
            }else {
                result.put(strings[0],strings[1]);
            }
        }
        return result;
    }

    public String[] splitString(String input){
        return input.split(";");
    }

    public List<String[]> splitKeyValuePair(String[] inputArray){
        List<String[]> keyValuePairs = new ArrayList<>();
        for(String keyValue : inputArray){
            keyValuePairs.add(keyValue.split("=",2));
        }
        return keyValuePairs;
    }

}
