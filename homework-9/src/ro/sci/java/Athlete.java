package ro.sci.java;

import java.util.ArrayList;

/**
 * This class models an athlete having name, nationality,number, time and shots.
 * Created by Adrian Migea on 16/02/2017.
 */
public class Athlete implements Comparable<Athlete> {
    private final int number;
    private final String name;
    private final String nationality;
    private Cronometer time;
    private Cronometer initialTime;
    private int penaltiesInSeconds = 0;
    private ArrayList<String> shots = new ArrayList<>();

    /**
     * This is the constructor.
     * @param number is the athlete number.
     * @param name is the athlete name.
     * @param nationality is the athlete nationality.
     * @param time is the athlete time.
     * @param shots is the athlete shots.
     */
    public Athlete(int number, String name, String nationality, Cronometer time, ArrayList<String> shots) {
        this.number = number;
        this.name = name;
        this.nationality = nationality;
        initialTime = time;
        this.time = time;
        this.shots = shots;
        computeTimeWithPenalties();
    }

    /**
     * This method returns the final time.
     * @return time
     */

    public Cronometer getFinalTime() {
        return time;
    }

    /**
     * This method calculates the time with penalties.
     */
    private void computeTimeWithPenalties() {
        Cronometer penalty = new Cronometer();
        for(String shotSeries : shots){
            penalty = timePenaltyForShootSeries(shotSeries);
            penaltiesInSeconds += penalty.getMinutes() * 60 + penalty.getSeconds();
            time.addTime(penalty);
        }
    }

    /**
     * This method returns the time penalty.
     * @param shotSeries is the athlete shots.
     * @return timePenalty.
     */
    private Cronometer timePenaltyForShootSeries(String shotSeries) {
        String [] result = shotSeries.split("");
        Cronometer timePenalty = new Cronometer();
        int k=0;
        for(String s : result){
            if(s.equals("o")){
                timePenalty.increaseSecondsWith(10);
                k++;
            }
        }
        return timePenalty;
    }

    @Override
    public int compareTo(Athlete o) {
        return this.time.compareTo(o.getFinalTime());
    }

    @Override
    public String toString() {
        return  name + " " +
                time.getMinutes() + ":" + time.getSeconds();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Athlete athlete = (Athlete) o;

        if (number != athlete.number) return false;
        if (name != null ? !name.equals(athlete.name) : athlete.name != null) return false;
        if (nationality != null ? !nationality.equals(athlete.nationality) : athlete.nationality != null) return false;
        if (time != null ? !time.equals(athlete.time) : athlete.time != null) return false;
        return shots != null ? shots.equals(athlete.shots) : athlete.shots == null;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (shots != null ? shots.hashCode() : 0);
        return result;
    }
}
