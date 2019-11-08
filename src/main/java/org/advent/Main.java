package org.advent;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        AdventCalendar calendar = new AdventCalendar();
        //Execute Entire Calendar
        calendar.execute();

        //Execute a Specific Day
        //calendar.getDay(1).execute();
    }
}
