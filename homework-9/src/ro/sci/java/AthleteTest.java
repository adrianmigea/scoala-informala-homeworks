package ro.sci.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * This is the AthleteTest class.
 * Created by Adrian Migea on 16/02/2017.
 */
public class AthleteTest {
    @Test
    public void AhleteTestOne() {
        Cronometer time = new Cronometer(30, 27);
        ArrayList<String> shots = new ArrayList<>();
        shots.add("xxxxx");
        shots.add("xxxxx");
        shots.add("xxxxx");
        Athlete expected = new Athlete(11, "Adrian Migea", "RO", time, shots);
        Cronometer correctTime = new Cronometer(30, 27);
        Assert.assertEquals(expected.getFinalTime(), correctTime);
    }

    @Test
    public void AthleteTestTwo() {
        Cronometer time = new Cronometer(40, 10);
        ArrayList<String> shots = new ArrayList<>();
        shots.add("xxxxo");
        shots.add("xxxxo");
        shots.add("xxxxo");
        Athlete expected = new Athlete(11, "Adrian Migea", "RO", time, shots);
        Cronometer correctTime = new Cronometer(40, 40);
        Assert.assertEquals(expected.getFinalTime(), correctTime);
    }

    @Test
    public void AthleteTestThree() {
        Cronometer time = new Cronometer(10, 10);
        ArrayList<String> shots = new ArrayList<>();
        shots.add("ooooo");
        shots.add("ooooo");
        shots.add("ooooo");
        Athlete expected = new Athlete(11, "Adrian Migea", "RO", time, shots);
        Cronometer correctTime = new Cronometer(12, 40);
        Assert.assertEquals(expected.getFinalTime(), correctTime);
    }

}