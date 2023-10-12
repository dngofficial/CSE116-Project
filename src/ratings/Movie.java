package ratings;

import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;

public class Movie extends Ratable{
    private String title;
    private ArrayList<String> cast_list;

    public Movie(String title, ArrayList<String> cast_list) {
        super(title);
        this.cast_list = cast_list;
    }

    public ArrayList<String> getCast() {
        return this.cast_list;
    }


    }

