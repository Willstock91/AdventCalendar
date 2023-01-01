package org.advent.models.problem2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.advent.models.problem2.RPS.ROCK;
import static org.advent.models.problem2.RPS.SCISSORS;

public class RPSRunner {

    private List<String> lines;
    private final int WIN = 6;
    private final int DRAW = 3;
    private final int LOSS = 0;

    public RPSRunner(File file) throws IOException {
        lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
    }

    public int getScore() {
        return lines.stream().mapToInt(line -> {
            String[] chars = line.split("");
            RPS left = RPS.getRPS(chars[0]);
            RPS right = RPS.getRPS(chars[2]);

            Result result = RPS.getResult(left, right);
            return result.getScore() + right.getScore();
        }).sum();
    }

    public int getStrategyScore() {
        return lines.stream().mapToInt(line -> {
            String[] chars = line.split("");
            RPS left = RPS.getRPS(chars[0]);

            Result result = Result.fromCode(chars[2]);

            RPS rpsForResult = RPS.getRPSForResult(left, result);

            return rpsForResult.getScore() + result.getScore();

        }).sum();
    }
}
