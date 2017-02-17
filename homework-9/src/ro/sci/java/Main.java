package ro.sci.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;


/**
 * This is the main class.
 * Created by Adrian Migea on 16/02/2017.
 */
public class Main {

    /**
     * This is the main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws  IOException{
        File csv = new File("biathlon.csv");
        ArrayList<Athlete> athletes = getAthletesFromFile(csv);

        Competition biathlonCompetition = new Competition(athletes);
        System.out.println("All athletes sorted:");
        System.out.println(biathlonCompetition.getAthletesInDescendingOrder());
        System.out.println("Winners:");

        System.out.println("Winner - " + biathlonCompetition.getWinners().get(0));
        System.out.println("Runner-up - " + biathlonCompetition.getWinners().get(1));
        System.out.println("Third place - " + biathlonCompetition.getWinners().get(2));
    }

    /**
     * This method gets athlete from file.
     * @param file is a file.
     * @return an ArrayList of athletes.
     */
    private static ArrayList<Athlete> getAthletesFromFile(File file) {
        ArrayList<Athlete> athletes = new ArrayList<>();
        try (Reader reader = new Reader(Files.newBufferedReader(file.toPath()))) {
            athletes = reader.readAthletes();
        } catch (IOException e) {
            System.err.println("File not found!");
            e.printStackTrace();
        }
        return athletes;
    }
}
