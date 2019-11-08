package org.advent;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdventCalendar {
    private Map<Integer, AdventDay> calendar;

    public AdventCalendar() {
        this.calendar = IntStream.rangeClosed(1, 25).mapToObj(AdventDay::new).collect(Collectors.toMap(AdventDay::getDay, Function.identity()));
    }

    public AdventDay getDay(Integer day) {
        return calendar.get(day);
    }

    public void execute() {
        calendar.values().forEach(AdventDay::execute);
    }
}
