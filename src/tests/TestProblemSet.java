package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;


public class TestProblemSet {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    @Test
    public void AverageTest() {

        ArrayList<Double> list = new ArrayList<>() {{
            add(2.5);
            add(2.5);
            add(2.5);
            add(2.5);
        }};
        assertTrue(ProblemSet.average(list) == 2.5);
        ArrayList<Double> list_dx = new ArrayList<>() {{
            add(6.5);
            add(6.5);
            add(8.5);
            add(8.5);
        }};
        assertTrue(ProblemSet.average(list_dx) == 7.5);

        ArrayList<Double> empty_list = new ArrayList<>();
        assertTrue(ProblemSet.average(empty_list) == 0.0);
    }
    @Test
    public void sumOfDigitsTest() {

        assertTrue(ProblemSet.sumOfDigits(-36) == 9);
        assertTrue(ProblemSet.sumOfDigits(1234) == 10);

        assertTrue(ProblemSet.sumOfDigits(57) == 12);
        assertTrue(ProblemSet.sumOfDigits(-100) == 1);

    }

    @Test
    public void bestKeyTest()
    {
        HashMap<String, Integer> map1 = new HashMap<String, Integer>() {{
            put("dog", 100);
            put("cat", 99);
            put("bird", 87);
        }};
        assertTrue(ProblemSet.bestKey(map1).equals("dog"));

        map1 = new HashMap<String, Integer>() {{
            put("dog", 100);
            put("cat", 100);
            put("bird", 87);
        }};
        assertTrue(ProblemSet.bestKey(map1).equals("dog") || ProblemSet.bestKey(map1).equals("cat"));

        map1 = new HashMap<String, Integer>() {{

        }};
        assertTrue(ProblemSet.bestKey(map1).equals(""));

    }
}