package org.advent;

import java.io.File;
import java.util.function.Function;

public class AdventProblem {

    private String problemKey;
    private File inputFile;
    private Function<File, String> logic;

    public AdventProblem(Integer day, Integer problemNumber) {
        this.problemKey = day + "." + problemNumber;
        this.inputFile = new File("src/main/resources/" + problemKey + ".txt");
        this.logic = AdventFunction.getProblemFunction(problemKey);
    }

    public String execute() {
        long startTime = System.currentTimeMillis();
        if(logic != null) {
            return "[Problem " + problemKey + " Result: " + logic.apply(this.inputFile) + ", Execution Time: " + (System.currentTimeMillis() - startTime) + "ms]";
        }
        return "[Problem " + problemKey + " Result: undefined]";
    }
}
