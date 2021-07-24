package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.Post;
import ru.job4j.grabber.Parse;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {
    private final DateTimeParser dateTimeParser;
    private final List<Post> posts = new ArrayList<>();

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    private List<Post> pageParser(String link) {
        return pageParser(link, 1);
    }

    private List<Post> pageParser(String link, int amount) {
        for (int i = 1; i <= amount; i++) {
            Document doc = null;
            try {
                doc = Jsoup.connect(link + i).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert doc != null;
            Elements table = doc.select(".forumTable").select("tbody").select("tr");
            for (Element tr : table) {
                Elements row = tr.select(".postslisttopic");
                Element thDate = tr.child(5);
                for (Element td : row) {
                    Element href = td.child(0);
                    //System.out.println(href.attr("href"));
                    //System.out.println(href.text());
                    //System.out.println(thDate.text());
                    //System.out.println(description(href.attr("href")));
                    Post post = new Post();
                    post.setTitle(href.text());
                    post.setLink(href.attr("href"));
                    post.setDescription(description(href.attr("href")));
                    post.setCreated(dateTimeParser.parse(thDate.text()));
                    posts.add(post);
                }
            }
        }
        return posts;
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

    @Override
    public List<Post> list(String link) {
        return pageParser(link);
    }

    @Override
    public Post detail(String link) {
        String text = description(link);
        return new Post(link, text);
    }

    public static void main(String[] args) {
        String link = "https://www.sql.ru/forum/job-offers/";
        String linkDetail =
                "https://www.sql.ru/forum/1335214/poisk-vedushhego-razrabotchika-bd-gorod-moskva";
        SqlRuParse sp = new SqlRuParse(new SqlRuDateTimeParser());
        List<Post> posts = sp.pageParser(link, 2);
        for (Post post : posts) {
            System.out.println(post);
        }
        //System.out.println(sp.detail(linkDetail));
    }
}
