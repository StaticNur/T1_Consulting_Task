package com.example.T1_Consulting_Task.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculateService {
    public String calculateSymbol(String str) {
        if (str.equals("")) {
            return "";
        }
        Map<String, Integer> charSumMap = new HashMap<>();
        String[] arrayChar = str.split("");
        for (String value : arrayChar) {
            charSumMap.merge(value, 1, Integer::sum);
        }

        Map<String, Integer> sortedMap =
                charSumMap.entrySet().stream()
                        .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));

        StringBuilder resultStr = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            resultStr.append("\"" + entry.getKey() + "\"");
            resultStr.append(": " + entry.getValue() + ", ");
        }

        resultStr.deleteCharAt(resultStr.length() - 1); //удалить последнюю запятую
        resultStr.deleteCharAt(resultStr.length() - 1);
        return String.valueOf(resultStr);
    }
}
