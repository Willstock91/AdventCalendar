package org.advent.models.problem2;

import static org.advent.models.problem2.Result.DRAW;
import static org.advent.models.problem2.Result.LOSS;
import static org.advent.models.problem2.Result.WIN;

public enum RPS {
    ROCK("A", "X", 1),
    PAPER("B", "Y", 2),
    SCISSORS("C", "Z", 3);

    private String first;
    private String second;
    private int score;

    RPS(String first, String second, int score) {
        this.first = first;
        this.second = second;
        this.score = score;
    }


    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public int getScore() {
        return score;
    }

    public static RPS getRPS(String value) {
        for(RPS rps: RPS.values()) {
            if(rps.first.equals(value) || rps.second.equals(value)) {
                return rps;
            }
        }
        return null;
    }

    public static RPS getRPSForResult(RPS rps, Result result) {
        switch (rps) {
            case ROCK:
                switch (result) {
                    case WIN:
                        return PAPER;
                    case DRAW:
                        return ROCK;
                    case LOSS:
                        return SCISSORS;
                }
            case PAPER:
                switch (result) {
                    case WIN:
                        return SCISSORS;
                    case DRAW:
                        return PAPER;
                    case LOSS:
                        return ROCK;
                }
            case SCISSORS:
                switch (result) {
                    case WIN:
                        return ROCK;
                    case DRAW:
                        return SCISSORS;
                    case LOSS:
                        return PAPER;
                }
            default:
                return null;
        }
    }

    public static Result getResult(RPS left, RPS right) {
        switch (left) {
            case ROCK:
                if(SCISSORS.equals(right)) {
                    return LOSS;
                } else if (ROCK.equals(right)) {
                    return DRAW;
                } else {
                    return WIN;
                }
            case PAPER:
                if(SCISSORS.equals(right)) {
                    return WIN;
                } else if (ROCK.equals(right)) {
                    return LOSS;
                } else {
                    return DRAW;
                }
            case SCISSORS:
                if(SCISSORS.equals(right)) {
                    return DRAW;
                } else if (ROCK.equals(right)) {
                    return WIN;
                } else {
                    return LOSS;
                }
            default:
                return null;
        }
    }
}
