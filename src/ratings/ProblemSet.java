package ratings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class ProblemSet {
    // TODO: Implement this method to return the average of all the numbers in the input ArrayList
    //       If the ArrayList is empty, return 0.0
    //
    // Examples
    // [1.0,2.0,3.0] returns 2.0
    // [-5.0,5.0] returns 0.0
    // [6.5,6.5,8.5,8.5] returns 7.5
    // [] returns 0.0

    public static double average(ArrayList<Double> numbers) {

        if (numbers.isEmpty()) {
            return 0.0; //return empty if nothing
        } else {
            double sum = 0;
            for (Double i : numbers) {
                //iterate through list and total it
                sum += i;
            }
            return (sum / numbers.size());
        }
    }
    // TODO: Write a public static method named sumOfDigits that takes an int as a parameter and
    //       returns the sum of the digits of the input as an int
    //
    // Examples
    // 123 returns 6
    // 57 returns 12
    // -36 returns 9
    public static int sumOfDigits(Integer number) {

        Integer sum_total = 0;
        String str_splitter = "" + number; //turn int into string

        String[] str_arr = str_splitter.split(""); //split the number string into an array

        for (String i : str_arr) {
            sum_total += Integer.parseInt(i); //iterate through the array, parse as an int and total it all up
        }

        return sum_total;

    }


    // TODO: Write a public static method named bestKey that takes a HashMap of String to Integer
    //       as a parameter and returns a key mapping to the largest Integer. Ties can be broken arbitrarily.
    //       If the HashMap is empty, return the empty String
    //
    // Examples
    // {"CSE": 100, "MTH": 90, "MGT": 10} returns "CSE"
    // {"cat": 5, "dog": 5, "fox": 4} can return either "cat" or "dog"
    // {} returns "

    public static String bestKey(HashMap<String, Integer> hashmap) {


        if (hashmap.isEmpty()) {
            return "";
        }
        else {
            int max_value = -2147483646;
            String return_string = "";
            for (String key : hashmap.keySet()) {
                int value = hashmap.get(key);
                if (value == max_value) { //if the value is the same there's a
                    if (Math.random() < 0.5) {
                        return_string = key;
                        max_value = value;
                    }
                }
                else if (value > max_value) {
                    return_string = key;
                    max_value = value;
                }
            }
            return return_string;
        }
    }
}
