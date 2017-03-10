package ro.sci.java;

import java.util.Map;

/**
 * This class models a statistic for a gate.
 * Created by Adrian Migea on 08/03/2017.
 */
public class Statistic extends Thread {

    public final Gate gate;

    /**
     * This is the constructor
     * @param gate is the festival gate.
     */
    public Statistic (Gate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        while(true) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(!gate.getPurchasedTickets().isEmpty()) {
                publishStatistics();
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * This method prints the statistics.
     */
    private void publishStatistics(){
        for (Map.Entry<Ticket, Integer> entry : gate.getPurchasedTickets().entrySet()){
            System.out.println(entry.getValue() + " TICKET TYPE: " + entry.getKey());
        }
    }

}

