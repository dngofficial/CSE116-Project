package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.HashMap;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestProblemSet {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    //we are testing EACH individual case

    @Test
    public void AverageTest1MutipleOfTheSameValue() {
        ArrayList<Double> list = new ArrayList<>() {{
            add(2.5);
            add(2.5);
            add(2.5);
            add(2.5);
        }};
        double test = ProblemSet.average(list);
        System.out.println(test);
        assertEquals(test, 2.5, 0.001);
    }

    @Test
    public void AverageTest2NormalAverage() {

        ArrayList<Double> list_dx = new ArrayList<>() {{
            add(6.5);
            add(6.5);
            add(8.5);
            add(8.5);
        }};
        double test = ProblemSet.average(list_dx);
        System.out.println(test);
        assertEquals(test, 7.5, 0.001);
    }
    @Test
    public void AverageTest3EmptyList() {
        ArrayList<Double> empty_list = new ArrayList<>();
        double test = ProblemSet.average(empty_list);

        System.out.println(test);
        assertEquals(test, 0.0, 0.001);
    }
    @Test
    public void AverageTest4SolutionShouldBe0() {

        ArrayList<Double> zero_list = new ArrayList<>(){{add(5.0); add(-5.0);}};
        double test = ProblemSet.average(zero_list);
        assertEquals(test, 0.0, 0.001);
    }

    @Test
    public void AverageTest5SingleTerm() {

        ArrayList<Double> zero_list = new ArrayList<>(){{add(5.0);}};
        double test = ProblemSet.average(zero_list);
        assertEquals(test, 5.0, 0.001);

        zero_list = new ArrayList<>(){{add(-5.0);}};
        test = ProblemSet.average(zero_list);
        assertEquals(test, -5.0, 0.001);
    }
    @Test
    public void sumOfDigitsTest1() {

        assertTrue(ProblemSet.sumOfDigits(1234) == 10);
        assertTrue("hi",ProblemSet.sumOfDigits(57) == 12);
        assertTrue("hi",ProblemSet.sumOfDigits(5734) == 19);

    }

    @Test
    public void sumOfDigitsTest2Negatives() {

        assertTrue(ProblemSet.sumOfDigits(-36) == 9);
        assertTrue(ProblemSet.sumOfDigits(-100) == 1);
        assertTrue(ProblemSet.sumOfDigits(-5734) == 19);
    }
@Test
    public void sumOfDigitsTest3EdgeCase0() {

        assertTrue(ProblemSet.sumOfDigits(0000) == 0);
        assertTrue(ProblemSet.sumOfDigits(-0000) == 0);
    }

    @Test
    public void bestKeyTest1() {
        HashMap<String, Integer> map1 = new HashMap<String, Integer>() {{
            put("dog", 100);
            put("cat", 99);
            put("bird", 87);
        }};
        assertTrue(ProblemSet.bestKey(map1).equals("dog"));
    }
    @Test
    public void bestKeyTest2SameValue() {
        HashMap<String, Integer> map1 = new HashMap<String, Integer>() {{
            put("dog", 100);
            put("cat", 100);
            put("bird", 87);
        }};
        String str_test = ProblemSet.bestKey(map1);
        System.out.println(str_test);
        assertTrue(str_test.equals("dog") || str_test.equals("cat"));
    }

    @Test
    public void bestKeyTest3NegativeHighestValue() {
        HashMap<String, Integer> map1 = new HashMap<String, Integer>() {{
            put("dog", -87);
            put("cat", -90);
            put("bird", -100);
        }};
        String str_test = ProblemSet.bestKey(map1);
        System.out.println(str_test);
        assertTrue(ProblemSet.bestKey(map1).equals("dog"));
    }
    @Test

    public void bestKeyTest4SameValueNegativeHighest() {
        HashMap<String, Integer> map1 = new HashMap<String, Integer>() {{
            put("dog", -100);
            put("cat", -100);
            put("bird", -120);
        }};
        String str_test = ProblemSet.bestKey(map1);
        System.out.println(str_test);
        assertTrue(str_test.equals("dog") || str_test.equals("cat"));
    }
    @Test
    public void bestKeyTest5EdgeCaseEmptyMap() {
    HashMap<String, Integer> map1 = new HashMap<String, Integer>() {{

        }};
        assertTrue(ProblemSet.bestKey(map1).equals(""));

    }
}