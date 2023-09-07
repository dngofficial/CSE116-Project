package ratings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class ProblemSet {


    public static double average(ArrayList<Double> numbers) {


        // TODO: Implement this method to return the average of all the numbers in the input ArrayList
        //       If the ArrayList is empty, return 0.0
        //
        // Examples
        // [1.0,2.0,3.0] returns 2.0
        // [-5.0,5.0] returns 0.0
        // [6.5,6.5,8.5,8.5] returns 7.5
        // [] returns 0.0

        if (numbers.isEmpty()) {
            return 0.0;
        } else {
            int counter = 0;
            double sum = 0;
            for (int i = 0; i < numbers.size(); i++) {
                sum += numbers.get(i);
                counter++;
            }
            return (sum / counter);

        }
    }

    public static int sumOfDigits(Integer number) {

        // TODO: Write a public static method named sumOfDigits that takes an int as a parameter and
        //       returns the sum of the digits of the input as an int
        //
        // Examples
        // 123 returns 6
        // 57 returns 12
        // -36 returns 9

        Integer sum_total = 0;
        String str_splitter = "" + number;

        String[] str_arr = str_splitter.split("");

        for (int i = 0; i < str_arr.length; i++) {
            sum_total += Integer.parseInt(str_arr[i]);
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
        } else {

            int max_value = -2147483646;
            String return_string = "";
            for (String key : hashmap.keySet()) {
                int value = hashmap.get(key);
                if (value == max_value) {
                    if (Math.random() < 0.5) {
                        return_string = key;
                        max_value = value;                    }
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
