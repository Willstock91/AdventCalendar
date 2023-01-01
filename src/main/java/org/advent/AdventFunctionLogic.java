package org.advent;


import org.advent.models.problem2.RPSRunner;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.*;

public class AdventFunctionLogic {
    private static Map<String, AdventFunction<File, String>> functions = new HashMap<>();

    private static AdventFunction<File, String> problem1_1 = (file) -> {
        Set<Integer> totals = new HashSet<>();
        Iterator<String> it = FileUtils.readLines(file, "UTF-8").iterator();
        int currentTotal = 0;

        while(it.hasNext()) {
            String line = it.next();

            if(line != null && !line.isEmpty()) {
                currentTotal += Integer.valueOf(line);
            } else {
                totals.add(currentTotal);
                currentTotal = 0;
            }
        }
        return Collections.max(totals).toString();
    };

    private static AdventFunction<File, String> problem1_2 = (file) -> {
        List<Integer> totals = new ArrayList<>();
        Iterator<String> it = FileUtils.readLines(file, "UTF-8").iterator();
        int currentTotal = 0;

        while(it.hasNext()) {
            String line = it.next();

            if(line != null && !line.isEmpty()) {
                currentTotal += Integer.valueOf(line);
            } else {
                totals.add(currentTotal);
                currentTotal = 0;
            }
        }

        totals.sort(Collections.reverseOrder());
        int sum = totals.subList(0, 3).stream().mapToInt(Integer::intValue).sum();
        return String.valueOf(sum);
    };

    private static AdventFunction<File, String> problem2_1 = (file) -> {
        RPSRunner runner = new RPSRunner(file);
        return String.valueOf(runner.getScore());
    };

    private static AdventFunction<File, String> problem2_2 = (file) -> {
        RPSRunner runner = new RPSRunner(file);
        return String.valueOf(runner.getStrategyScore());
    };

    static {
        functions.put("1.1", problem1_1);
        functions.put("1.2", problem1_2);
        functions.put("2.1", problem2_1);
        functions.put("2.2", problem2_2);
    }
    public static AdventFunction<File, String> getProblemLogic(String key) {
        return functions.get(key);
    }
}
