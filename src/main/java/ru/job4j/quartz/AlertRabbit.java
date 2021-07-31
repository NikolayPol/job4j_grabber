package ru.job4j.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class AlertRabbit {
    public static void main(String[] args) {
        try (Connection connection = AlertRabbit.connect()) {
            List<Long> store = new ArrayList<>();

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            scheduler.start();

            JobDataMap data = new JobDataMap();
            data.put("connection", connection);
            data.put("store", store);
            //data.put("createdJob", createdJob(connection));

            JobDetail job = newJob(Rabbit.class)
                    .usingJobData(data)
                    .build();

            SimpleScheduleBuilder times = simpleSchedule()
                    .withIntervalInSeconds(Integer.parseInt(readProperties()
                            .getProperty("rabbit.interval")))
                    .repeatForever();

            Trigger trigger = newTrigger()
                    .startNow()
                    .withSchedule(times)
                    .build();

            scheduler.scheduleJob(job, trigger);
            Thread.sleep(10000);
            scheduler.shutdown();
            System.out.println(store);

        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    public static boolean createdJob(Connection connection) {
        boolean res = true;
        try (Statement statement = connection.createStatement()) {
            statement.execute("insert into rabbit(created_date) "
                    + "values (localtimestamp)");
        } catch (Exception e) {
            res = false;
            e.printStackTrace();
        }
        return res;
    }

    public static Connection connect() {
        try {
            Class.forName(readProperties().getProperty("jdbc.driver"));
            Connection cn = DriverManager.getConnection(
                    readProperties().getProperty("url"),
                    readProperties().getProperty("username"),
                    readProperties().getProperty("password"));
            return cn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Properties readProperties() {
        Properties config = new Properties();
        try (InputStream in = AlertRabbit.class.getClassLoader()
                .getResourceAsStream("log4j.properties")) {
            config.load(in);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return config;
    }

    public static class Rabbit implements Job {
        public Rabbit() {
            System.out.println(hashCode());
        }

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("Rabbit runs here ...");
            List<Long> store = (List<Long>) context
                    .getJobDetail().getJobDataMap().get("store");
            store.add(System.currentTimeMillis());
            Connection connection = (Connection) context
                    .getJobDetail().getJobDataMap().get("connection");
            createdJob(connection);
        }
    }
}