package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        pageParser(5);
    }

    private static void pageParser(int amount) throws IOException {
        for (int i = 0; i < amount; i++) {
            Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers/" + amount).get();
            Elements table = doc.select(".forumTable").select("tbody").select("tr");
            //System.out.println(table);
            for (Element tr : table) {
                Elements row = tr.select(".postslisttopic");
                Element thDate = tr.child(5);
                for (Element td : row) {
                    Element href = td.child(0);
                    System.out.println(href.attr("href"));
                    System.out.println(href.text());
                    System.out.println(thDate.text());
                    System.out.println(description(href.attr("href")));
                }
            }
        }

    }

    public static String description(String href) {
        String text = null;
        try {
            Document doc = Jsoup.connect(href).get();
            Element table = doc.select(".msgTable")
                    .select("tbody")
                    .select("tr")
                    .select(".msgBody")
                    .get(1);
            text = table.text();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return text;
    }
}
