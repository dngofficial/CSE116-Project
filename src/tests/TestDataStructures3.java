package tests;

import org.junit.Before;
import org.junit.Test;
import ratings.*;
import static org.junit.Assert.*;


import java.util.ArrayList;


public class TestDataStructures3 {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    //we are testing EACH individual case

    private DegreesOfSeparation separation;
    private ArrayList<Movie> expected;

    @Before
    public void setUpFileReader() {
        expected = new ArrayList<>(){{
            add(new Movie("American Pie", new ArrayList<String>() {{
                add("Kevin Bacon");
                add("Lindsay Crouse");
            }}));

            add(new Movie("Jay and Silent Bob Strike Back", new ArrayList<String>() {{
                add("Lindsay Crouse");
                add("Fortnite Bob");
            }}));
            add(new Movie("Rebecca", new ArrayList<String>() {{
                add("Fortnite Bob");
                add("Griddy Demon Ohio");
            }}));
            add(new Movie("Jimmy", new ArrayList<String>() {{
                add("Kimmy");
            }}));
        }};

        separation = new DegreesOfSeparation(expected);
    }


    public void graphLoadTest()
    {
        System.out.println(separation.getGraph());
    }

    @Test
    public void degree()
    {
        assertTrue(separation.degreesOfSeparation("Kevin Bacon", "Kevin Bacon")  == 0);
        assertTrue(separation.degreesOfSeparation("Kevin Bacon", "Lindsay Crouse")  == 1);
        assertTrue(separation.degreesOfSeparation("Lindsay Crouse", "Kevin Bacon")  == 1);

        assertTrue(separation.degreesOfSeparation("Kevin Bacon", "Fortnite Bob")  == 2);
        assertTrue(separation.degreesOfSeparation("Fortnite Bob", "Kevin Bacon")  == 2);

        assertTrue(separation.degreesOfSeparation("Kevin Bacon", "DNE")  == -1);

        assertTrue(separation.degreesOfSeparation("Kevin Bacon", "Kimmy")  == -1);

        assertTrue(separation.degreesOfSeparation("Kimmy", "Kevin Bacon")  == -1);







    }

}