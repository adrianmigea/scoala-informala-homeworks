package ro.sci.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class models a reader.
 * Created by Adrian Migea on 16/02/2017.
 */
public class Reader extends BufferedReader{

    private static final String SEPARATOR = ",";

    public Reader(BufferedReader in) {
        super(in);
    }

    /**
     * This method reads athletes and returns an arrayList of athletes.
     * @return an ArrayList of athletes.
     * @throws IOException
     */

    public ArrayList<Athlete> readAthletes() throws IOException {
        String line = readLine();
        ArrayList<Athlete> athletes = new ArrayList<>();
        while(line != null){
            Athlete athlete = parseAthlete(line);
            athletes.add(athlete);
            line = readLine();
        }
        return athletes;
    }

    /**
     * This method is the parseAthlete method
     * @param source is a string.
     * @return Athlete.
     */
    private Athlete parseAthlete(String source) {
        String [] tokens = source.split(SEPARATOR);
        String [] times = tokens[3].split(":");
        Cronometer time = new Cronometer(Integer.valueOf(times[0]), Integer.valueOf(times[1]));
        ArrayList<String> shots = new ArrayList<>();
        shots.add(tokens[4]);
        shots.add(tokens[5]);
        shots.add(tokens[6]);
        return new Athlete(Integer.valueOf(tokens[0]), tokens[1], tokens[2], time, shots);
    }
}
