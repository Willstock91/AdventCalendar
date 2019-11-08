package org.advent;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class AdventFunction {
    private static Map<String, Function<File, String>> functions = new HashMap<>();

    private static Function<File, String> problem1_1 = (file) -> {
        try {
            int total = FileUtils.readLines(file, "UTF-8").stream().mapToInt(Integer::valueOf).sum();
            return String.valueOf(total);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    };

    static {
        functions.put("1.1", problem1_1);
    }
    public static Function<File, String> getProblemFunction(String key) {
        return functions.get(key);
    }
}
