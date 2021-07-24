package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {

        Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers").get();

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
            }
        }
    }
}