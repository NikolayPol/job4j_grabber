//package ru.job4j.tdd;
//
//import static org.junit.Assert.assertThat;
//import static org.hamcrest.Matchers.is;
//
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.List;
//import java.util.Random;
//
//public class CinemaTest {
//
//    @Test
//    public void buyTest() {
//        Account account = new AccountCinema();
//        Cinema cinema = new Cinema3D();
//        Calendar date = Calendar.getInstance();
//        date.set(2020, 10, 10, 23, 00);
//        Ticket ticket = cinema.buy(account, 1, 1, date);
//        //assertThat(ticket, is(new Ticket3D()));
//    }
//
//    @Test
//    public void findTest() {
//        Cinema cinema = new Cinema3D();
//        cinema.add(new Session3D());
//        List<Session> sessions = cinema.find(session -> true);
//        //assertThat(sessions, is(Arrays.asList(new Session3D())));
//    }
//
//    @Test
//    public void addTest() {
//        Cinema cinema = new Cinema3D();
//        cinema.add(new Session3D());
//        List<Session> sessions = cinema.find(session -> true);
//        //assertThat(sessions, is(Arrays.asList(new Session3D())));
//    }
//
////    @Test(expected = Exception.class)
////    public void buyTwoSameTicketTest() {
////        Account account = new AccountCinema();
////        Cinema cinema = new Cinema3D();
////        Calendar date = Calendar.getInstance();
////        date.set(2020, 10, 10, 23, 00);
////        Ticket ticket1 = cinema.buy(account, 1, 1, date);
////        Ticket ticket2 = cinema.buy(account, 1, 1, date);
////    }
////
////    @Test(expected = Exception.class)
////    public void buyIncorrectTicketTest() {
////        Account account = new AccountCinema();
////        Cinema cinema = new Cinema3D();
////        Calendar date = Calendar.getInstance();
////        date.set(2020, 10, 10, 23, 00);
////        Random r = new Random();
////        int row = r.nextInt(Integer.MAX_VALUE) * (-1);
////        int column = r.nextInt(Integer.MAX_VALUE) * (-1);
////        Ticket ticket = cinema.buy(account, row, column, date);
////    }
////
////    @Test(expected = Exception.class)
////    public void IncorrectDateTest() {
////        Account account = new AccountCinema();
////        Cinema cinema = new Cinema3D();
////        Calendar date = Calendar.getInstance();
////        date.set(2022, 10, 10, 23, 00);
////        Ticket ticket = cinema.buy(account, 1, 1, date);
////    }
//}