package org.advent;


public class Main {

    public static void main(String[] args) {
        AdventCalendar calendar = new AdventCalendar();
        //Execute Entire Calendar
        //calendar.execute();

        //Execute a Specific Day
        calendar.getDay(2).execute();
    }
}
