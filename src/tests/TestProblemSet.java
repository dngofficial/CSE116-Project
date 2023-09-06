package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class TestProblemSet {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<Double>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        System.out.println("" + ratings.ProblemSet.average(list));

        System.out.println("" + ratings.ProblemSet.sumOfDigits(123));

    }

}