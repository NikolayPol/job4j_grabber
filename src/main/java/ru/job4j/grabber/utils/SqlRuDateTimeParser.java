package ru.job4j.grabber.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SqlRuDateTimeParser implements DateTimeParser {
    private static final Map<String, Integer> MONTH = new HashMap<>();

    static {
        MONTH.put("янв", 1);
        MONTH.put("фев", 2);
        MONTH.put("мар", 3);
        MONTH.put("апр", 4);
        MONTH.put("май", 5);
        MONTH.put("июн", 6);
        MONTH.put("июл", 7);
        MONTH.put("авг", 8);
        MONTH.put("сен", 9);
        MONTH.put("окт", 10);
        MONTH.put("ноя", 11);
        MONTH.put("дек", 12);
    }

    @Override
    public LocalDateTime parse(String parse) {
        String time = parse.replace(",", "");
        time = time.replace(":", " ");
        String[] arr = time.split(" ");
        if (arr[0].equals("сегодня")) {
            arr = new String[]{
                    String.valueOf(LocalDateTime.now().getDayOfMonth()),
                    String.valueOf(LocalDateTime.now().getMonth().getValue()),
                    String.valueOf(LocalDateTime.now().getYear()).substring(2),
                    arr[1],
                    arr[2]};

        } else if (arr[0].equals("вчера")) {
            arr = new String[]{
                    String.valueOf(LocalDateTime.now().getDayOfMonth() - 1),
                    String.valueOf(LocalDateTime.now().getMonth().getValue()),
                    String.valueOf(LocalDateTime.now().getYear()).substring(2),
                    arr[1],
                    arr[2]};
        }
        int year = Integer.parseInt("20" + arr[2]);
        int month = MONTH.get(arr[1]);
        int day = Integer.parseInt(arr[0]);
        int hour = Integer.parseInt(arr[3]);
        int minute = Integer.parseInt(arr[4]);
        return LocalDateTime.of(year, month, day, hour, minute);
    }

//    public static void main(String[] args) {
//        SqlRuDateTimeParser sr = new SqlRuDateTimeParser();
//        String time = "7 янв 21, 15:02";
//        LocalDateTime res = sr.parse(time);
//        System.out.println(res);
//    }
}
