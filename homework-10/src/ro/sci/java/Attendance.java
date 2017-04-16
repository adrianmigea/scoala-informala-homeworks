package ro.sci.java;

import java.util.Random;

/**
 * This class models an attendance.
 * This class extends Thread.
 * Created by Adrian Migea on 08/03/2017.
 */
public class Attendance extends Thread {
    private Gate gate;
    private Ticket ticket;
    private Random random = new Random();

    /**
     * This is the constructor.
     * @param gate is the festival gate.
     * @param ticket is the festival ticket.
     */
    public Attendance(Gate gate, Ticket ticket) {
        this.gate = gate;
        this.ticket = ticket;
    }

    /**
     * This method makes the thread sleep for a random below 1 seconds time wait,
     * then starts it, then joins it.
     */
    public void confirmTicket(){
        try {
            sleep(random.nextInt(10) * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        start();

        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        synchronized (this){
            System.out.println(ticket);
            gate.addTicket(ticket);
        }
    }
}
