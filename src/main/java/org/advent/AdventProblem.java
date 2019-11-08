package org.advent;

import java.io.File;

public class AdventProblem {

    private String problemKey;
    private File inputFile;
    private AdventFunction<File, String> logic;

    public AdventProblem(Integer day, Integer problemNumber) {
        this.problemKey = day + "." + problemNumber;
        this.inputFile = new File("src/main/resources/" + problemKey + ".txt");
        this.logic = AdventFunctionLogic.getProblemLogic(problemKey);
    }

    public String execute() {
        long startTime = System.currentTimeMillis();
        if(logic != null) {
            try {
                return "[Problem " + problemKey + " Result: " + logic.apply(this.inputFile) + ", Execution Time: " + (System.currentTimeMillis() - startTime) + "ms]";
            } catch (Exception e) {
                throw new RuntimeException("Error executing problem " + problemKey + " logic!", e);
            }

        }
        return "[Problem " + problemKey + " Result: undefined]";
    }
}
