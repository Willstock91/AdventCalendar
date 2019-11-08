package org.advent;

public class AdventDay {

    private Integer day;
    private AdventProblem problem1;
    private AdventProblem problem2;

    public AdventDay(Integer day) {
        this.day = day;
        this.problem1 = new AdventProblem(day, 1);
        this.problem2 = new AdventProblem(day, 2);
    }

    public Integer getDay() {
        return day;
    }

    public AdventProblem getProblem1() {
        return problem1;
    }

    public AdventProblem getProblem2() {
        return problem2;
    }

    public void execute() {
        System.out.println(problem1.execute());
        System.out.println(problem2.execute());
    }
}
