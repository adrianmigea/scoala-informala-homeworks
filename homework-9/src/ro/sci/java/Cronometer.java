package ro.sci.java;


/**
 * This class models a cronometer having minutes and seconds.
 * Created by Adrian Migea on 16/02/2017.
 */
public final class Cronometer implements Comparable<Cronometer> {
    private int minutes;
    private int seconds;

    /**
     * This is the constructor.
     */
    public Cronometer() {
        minutes = 0;
        seconds = 0;
    }

    /**
     * This is the constructor.
     * @param minutes is the athlete time.
     * @param seconds is the athlete time.
     * @throws IllegalArgumentException
     */
    public Cronometer(int minutes, int seconds) throws IllegalArgumentException{
        this.minutes = minutes;
        if(seconds < 60) {
            this.seconds = seconds;
        } else if(seconds == 60){
            this.minutes++;
        } else {
            throw new IllegalArgumentException("Seconds must be below 60");
        }
    }

    public int getMinutes() {
        return minutes;
    }

    /**
     * This method increase the minutes.
     * @param minutes
     */
    public void increaseMinutesWith(int minutes){
        this.minutes += minutes;
    }

    /**
     * This method increase the second.
     * @param seconds
     */
    public void increaseSecondsWith(int seconds){
        this.minutes += seconds / 60;
        this.seconds += seconds % 60;
        if(this.seconds > 60){
            this.minutes += this.seconds / 60;
            this.seconds = this.seconds % 60;
        } else if(this.seconds == 60){
            this.minutes++;
            this.seconds = 0;
        }
    }

    public int getSeconds() {
        return seconds;
    }

    /**
     * This method adds time object to another one.
     * @param time is the time you add to the current object.
     */

    public void addTime(Cronometer time) throws IllegalArgumentException{
        if(time == null){
            throw new IllegalArgumentException();
        }
        else {
            this.minutes += time.getMinutes();
            this.minutes += time.getSeconds() / 60;
            this.seconds += time.getSeconds() % 60;
            if (this.seconds > 60) {
                this.minutes += this.seconds / 60;
                this.seconds = this.seconds % 60;
            } else if (this.seconds == 60) {
                this.minutes++;
                this.seconds = 0;
            }
        }
    }

    @Override
    public int compareTo(Cronometer o) {
        if(this.minutes > o.minutes){
            return 1;
        } else if(this.minutes < o.minutes){
            return -1;
        } else if(this.seconds > o.seconds){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Time{" +
                "minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cronometer time = (Cronometer) o;

        if (minutes != time.minutes) return false;
        return seconds == time.seconds;
    }

    @Override
    public int hashCode() {
        int result = minutes;
        result = 31 * result + seconds;
        return result;
    }
}