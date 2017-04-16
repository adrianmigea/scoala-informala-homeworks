package ro.sci.java;

import java.util.Random;

/**
 * This is the main class.
 * Created by Adrian Migea on 8/03/2017.
 */
public class Main {

    /**
     * This is the main method.
     * @param args
     */
    public static void main(String[] args) {
        Gate gate = new Gate();
        Random random = new Random();

        Statistic sts = new Statistic(gate);
        try {
            sts.start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        int attendees = random.nextInt(1000) + 100;

        for (int i = 0; i < attendees; i++) {
            Ticket ticket = Ticket.values()[random.nextInt(Ticket.values().length)];
            Attendance att = new Attendance(gate, ticket);
            att.confirmTicket();
        }
    }
}