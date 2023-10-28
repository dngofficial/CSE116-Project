package ratings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReader{
    public FileReader() {

    }

    public static ArrayList<Movie> readMovies(String filename) {

        try {
            ArrayList<Movie> return_arraylist = new ArrayList<Movie>();
            ArrayList<String> master_csv_lines = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            for (String unsplit_movie_list :  master_csv_lines)
            {
                ArrayList<String> split_string_movie = new ArrayList<>(Arrays.asList(unsplit_movie_list.split(",")));
                ArrayList<String> movie_cast_list = new ArrayList<String>();
                String movie_title = " ";
                for (int i = 0; i < split_string_movie.size(); i++) {
                    if (i == 0)
                    {
                        movie_title = split_string_movie.get(i);
                    }
                    else
                    {
                        movie_cast_list.add(split_string_movie.get(i));
                    }
                }
                return_arraylist.add(new Movie(movie_title, movie_cast_list));
            }
            return return_arraylist;
        } catch (IOException e) {
            return new ArrayList<>();
        }

    }





}
