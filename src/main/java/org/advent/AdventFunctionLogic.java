package org.advent;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdventFunctionLogic {
    private static Map<String, AdventFunction<File, String>> functions = new HashMap<>();

    private static AdventFunction<File, String> problem1_1 = (file) -> {
        int total = FileUtils.readLines(file, "UTF-8").stream().mapToInt(Integer::valueOf).sum();
        return String.valueOf(total);
    };

    private static AdventFunction<File, String> problem1_2 = (file) -> {
        HashSet<Integer> found = new HashSet<>();
        int start = 0;
        List<Integer> values = FileUtils.readLines(file, "UTF-8").stream().map(Integer::valueOf).collect(Collectors.toList());
        while(true) {
            for(Integer v : values) {
                start += v;
                if(found.contains(start)) {
                    return String.valueOf(start);
                }
                found.add(start);
            }
        }
    };

    static {
        functions.put("1.1", problem1_1);
        functions.put("1.2", problem1_2);
    }
    public static AdventFunction<File, String> getProblemLogic(String key) {
        return functions.get(key);
    }
}
