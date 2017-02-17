package ro.sci.java;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class models a competition.
 * Created by Adrian Migea on 16/02/2017.
 */
public class Competition {
    private ArrayList<Athlete> athletes = new ArrayList<>();
    private ArrayList<Athlete> winners = new ArrayList<>();

    /**
     * This is the constructor.
     * @param athletes is an ArrayList
     * @throws IllegalArgumentException
     */
    public Competition(ArrayList<Athlete> athletes) throws IllegalArgumentException{
        if(athletes == null) {
            throw new IllegalArgumentException();
        } else if(athletes.isEmpty()){
            throw new IllegalArgumentException();
        } else {
            this.athletes = athletes;
            Collections.sort(this.athletes);
            if (this.athletes.size() >= 3) {
                winners.add(athletes.get(0));
                winners.add(athletes.get(1));
                winners.add(athletes.get(2));
            } else {
                System.err.println("Couldn't create the winners list due to the fact that there are below 3 participants");
            }
        }
    }


    public ArrayList<Athlete> getWinners () {
            return winners;
    }

    public ArrayList<Athlete> getAthletesInDescendingOrder () {
        return athletes;
    }

}


