package ro.sci.java;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the CronometerTest class.
 * Created by Adrian Migea on 16/02/2017.
 */
public class CronometerTest {
    @Test
    public void CronometerTestOne() {
        Cronometer t = new Cronometer(30, 2);
        t.increaseMinutesWith(20);
        Cronometer expected = new Cronometer(50, 2);
        Assert.assertEquals(t,expected);
    }

    @Test
    public void CronometerTestTwo(){
        Cronometer t = new Cronometer(30, 2);
        Cronometer t2 = new Cronometer(20, 59);
        t.addTime(t2);
        Cronometer expected = new Cronometer(51, 1);
        Assert.assertEquals(t, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void CronometerTestThree(){
        Cronometer t = new Cronometer(30, 2);
        Cronometer t2 = null;
        t.addTime(t2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void CronometerTestFour(){
        Cronometer t = new Cronometer(30, 85);
    }

}