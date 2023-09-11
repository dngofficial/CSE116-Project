package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import static org.junit.Assert.assertTrue;

public class TestProblemSet {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

        @Test
    public void StringTest() {

        ArrayList<Double> list = new ArrayList<>() {{add(2.5); add(2.5); add(2.5); add(2.5);}};
        assertTrue(ProblemSet.average(list) == 2.5);
        ArrayList<Double> list_dx = new ArrayList<>() {{add(2.5); add(2.5); add(2.5); add(2.5);}};

            ArrayList<Double> empty_list = new ArrayList<>();
        assertTrue(ProblemSet.average(empty_list) == 0.0);




            System.out.println("" + ProblemSet.average(list));


        System.out.println("" + ProblemSet.sumOfDigits(123));

        assertTrue(ProblemSet.sumOfDigits(-36) == 9);
        assertTrue(ProblemSet.sumOfDigits(1234) == 10);



            HashMap<String, Integer> bills = new HashMap<>();

            bills.put("real", 100);
            bills.put("real", 100);

            bills.put("real;y", 11);


            System.out.print(ProblemSet.bestKey(bills));

        }


}