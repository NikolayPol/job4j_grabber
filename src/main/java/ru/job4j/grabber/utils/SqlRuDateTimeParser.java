package ru.job4j.grabber.utils;

import java.time.LocalDateTime;

public class SqlRuDateTimeParser implements DateTimeParser {
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
        int month = monthConvert(arr[1]);
        int day = Integer.parseInt(arr[0]);
        int hour = Integer.parseInt(arr[3]);
        int minute = Integer.parseInt(arr[4]);
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public int monthConvert(String month) {
        int res = -1;
        if (month.equals("янв") || month.equals("1")) {
            res = 1;
        }
        if (month.equals("фев") || month.equals("2")) {
            res = 2;
        }
        if (month.equals("мар") || month.equals("3")) {
            res = 3;
        }
        if (month.equals("апр") || month.equals("4")) {
            res = 4;
        }
        if (month.equals("май") || month.equals("5")) {
            res = 5;
        }
        if (month.equals("июн") || month.equals("6")) {
            res = 6;
        }
        if (month.equals("июл") || month.equals("7")) {
            res = 7;
        }
        if (month.equals("авг") || month.equals("8")) {
            res = 8;
        }
        if (month.equals("сен") || month.equals("9")) {
            res = 9;
        }
        if (month.equals("окт") || month.equals("10")) {
            res = 10;
        }
        if (month.equals("ноя") || month.equals("11")) {
            res = 11;
        }
        if (month.equals("дек") || month.equals("12")) {
            res = 12;
        }
        return res;
    }

//    public static void main(String[] args) {
//        SqlRuDateTimeParser sr = new SqlRuDateTimeParser();
//        String time = "7 янв 21, 15:02";
//        LocalDateTime res = sr.parse(time);
//        System.out.println(res);
//    }
}
