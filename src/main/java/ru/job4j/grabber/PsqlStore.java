package ru.job4j.grabber;

import ru.job4j.Post;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;
import ru.job4j.html.SqlRuParse;
import ru.job4j.quartz.AlertRabbit;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {

    private Connection cnn;

    public PsqlStore(Properties cfg) {
        try {
            Class.forName(cfg.getProperty("jdbc.driver"));
            cnn = DriverManager.getConnection(
                    cfg.getProperty("url"),
                    cfg.getProperty("username"),
                    cfg.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Post post) {
        String title = post.getTitle();
        String link = post.getLink();
        String description = post.getDescription();
        LocalDateTime created = post.getCreated();
        Timestamp timestamp = Timestamp.valueOf(created);
        try (PreparedStatement statement = cnn
                .prepareStatement("insert into post(name, link, text, created) "
                        + "values (?, ?, ?, ?)")) {
            statement.setString(1, title);
            statement.setString(2, link);
            statement.setString(3, description);
            statement.setTimestamp(4, timestamp);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        try (Statement statement = cnn.createStatement()) {
            ResultSet rs = statement.executeQuery("select * from post ");
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt(1));
                post.setTitle(rs.getString(2));
                post.setLink(rs.getString(3));
                post.setDescription(rs.getString(4));
                post.setCreated(rs.getTimestamp(5).toLocalDateTime());
                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post findById(String id) {
        Post post = new Post();
        String sql = String.format(
                "select * from post where id = %s",
                id);
        try (Statement statement = cnn.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                post.setId(rs.getInt(1));
                post.setTitle(rs.getString(2));
                post.setLink(rs.getString(3));
                post.setDescription(rs.getString(4));
                post.setCreated(rs.getTimestamp(5).toLocalDateTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }

    public static void main(String[] args) {
        // Ссылка на страницу для парсинга
        String link = "https://www.sql.ru/forum/job-offers/";
        // Создаем объект конфиг и добавляем данные из конфиг-файла
        Properties config = new Properties();
        try (InputStream in = AlertRabbit.class.getClassLoader()
                .getResourceAsStream("log4j.properties")) {
            config.load(in);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        // Создаем Парсер
        SqlRuParse sp = new SqlRuParse(new SqlRuDateTimeParser());
        // Создаем Хранилище
        PsqlStore ps = new PsqlStore(config);

        //Добавляем в Базу данных
        //List<Post> posts = sp.list(link, 1);
//        for (Post post : posts) {
//            //System.out.println(post);
//            ps.save(post);
//        }

        //Читаем из базы данных
//        List<Post> postsFromDb = ps.getAll();
//        for (Post post : postsFromDb) {
//            System.out.println(post);
//        }

        // Получаем запись по id
        Post postFromDB = ps.findById("7");
        System.out.println(postFromDB);
    }
}
