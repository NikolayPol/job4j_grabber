package ru.job4j.grabber.utils;

import java.time.LocalDateTime;

public class SqlRuDateTimeParser implements DateTimeParser {
    @Override
    public LocalDateTime parse(String parse) {
        String time = parse.replace(",", "");
        time = time.replace(":", " ");
        String[] arr = time.split(" ");
        int year = Integer.parseInt("20" + arr[2]);
        int month = monthConvert(arr[1]);
        int day = Integer.parseInt(arr[0]);
        int hour = Integer.parseInt(arr[3]);
        int minute = Integer.parseInt(arr[4]);
        LocalDateTime res = LocalDateTime.of(year, month, day, hour, minute);
        return res;
    }

    public int monthConvert(String month) {
        int res = -1;
        if (month.equals("янв")) {
            res = 1;
        }
        if (month.equals("фев")) {
            res = 2;
        }
        if (month.equals("мар")) {
            res = 3;
        }
        if (month.equals("апр")) {
            res = 4;
        }
        if (month.equals("май")) {
            res = 5;
        }
        if (month.equals("июн")) {
            res = 6;
        }
        if (month.equals("июл")) {
            res = 7;
        }
        if (month.equals("авг")) {
            res = 8;
        }
        if (month.equals("сен")) {
            res = 9;
        }
        if (month.equals("окт")) {
            res = 10;
        }
        if (month.equals("ноя")) {
            res = 11;
        }
        if (month.equals("дек")) {
            res = 12;
        }
        return res;
    }

    public static void main(String[] args) {
        SqlRuDateTimeParser sr = new SqlRuDateTimeParser();
        String time = "7 янв 21, 15:02";
        LocalDateTime res = sr.parse(time);
        System.out.println(res);
    }
}
