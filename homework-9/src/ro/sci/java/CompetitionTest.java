package ro.sci.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * This is the CompetitionTest class.
 * Created by Adrian Migea on 16/02/2017.
 */
public class CompetitionTest {
    @Test
    public void CompetitionTestOne() {
        Cronometer t1 = new Cronometer(30, 20);
        Cronometer t2 = new Cronometer(31, 20);
        Cronometer t3 = new Cronometer(32,30);
        ArrayList<String> shots1 = new ArrayList<>();
        ArrayList<String> shots2 = new ArrayList<>();
        ArrayList<String> shots3 = new ArrayList<>();
        shots1.add("xxxxx");
        shots1.add("xxxxx");
        shots1.add("xxxxx");
        shots2.add("xxxxx");
        shots2.add("xxxxx");
        shots2.add("xxxxx");
        shots3.add("xxxxx");
        shots3.add("xxxxx");
        shots3.add("xxxxx");
        Athlete a1 = new Athlete(2, "marius", "RO", t1, shots1);
        Athlete a2 = new Athlete(2, "alin", "RO", t2, shots1);
        Athlete a3 = new Athlete(4,"andrei","RO",t3,shots3);
        ArrayList<Athlete> athletes = new ArrayList<>();
        athletes.add(a2);
        athletes.add(a1);
        athletes.add(a3);
        Competition biathlonCompetition = new Competition(athletes);
        ArrayList<Athlete> result;
        result = biathlonCompetition.getAthletesInDescendingOrder();

        ArrayList<Athlete> expected = new ArrayList<>();
        expected.add(a1);
        expected.add(a2);
        expected.add(a3);
        Assert.assertEquals(result.equals(expected), true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void CompetitionTestTwo(){
        ArrayList<Athlete> athletes = null;
        Competition biathlonCompetition = new Competition(athletes);
    }

}