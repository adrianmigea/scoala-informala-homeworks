package ro.sci.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * This class models a gate.
 * Created by Adrian Migea on 08/03/2017.
 */
public class Gate {

    private Queue<Ticket> ticketsQueue = new LinkedList<>();
    private Map<Ticket, Integer> purchasedTickets = new HashMap<>();

    /**
     * This is the constructor.
     */
    public Gate() {
        for(Ticket t : Ticket.values()){
            purchasedTickets.put(t, 0);
        }
    }

    /**
     * This method adds tickets to the queue and counts the tickets.
     * @param ticket is the festival ticket.
     */
    public void addTicket(Ticket ticket){
        ticketsQueue.add(ticket);
        int ticketsOfKind = purchasedTickets.get(ticket);
        purchasedTickets.put(ticket, ticketsOfKind + 1);
    }

    public Map<Ticket, Integer> getPurchasedTickets() {
        return purchasedTickets;
    }

    /**
     * This method clears the queue and the map.
     */
    public void clearData(){
        ticketsQueue.clear();
        purchasedTickets.clear();
    }
}

