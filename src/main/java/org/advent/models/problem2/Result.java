package org.advent.models.problem2;

public enum Result {

    WIN("Z", 6),
    DRAW("Y", 3),
    LOSS("X", 0);
    private final String code;
    private final int score;

    Result(String code, int score) {
        this.code = code;
        this.score = score;
    }

    public String getCode() {
        return code;
    }

    public int getScore() {
        return score;
    }

    public static Result fromCode(String code) {
        for(Result result : Result.values()) {
            if(result.code.equals(code)) {
                return result;
            }
        }
        return null;
    }
}
