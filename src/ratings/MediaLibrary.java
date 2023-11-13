package ratings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MediaLibrary {

    private ArrayList<Ratable> masterRatableList  = new ArrayList<Ratable>();
    public MediaLibrary() {
    }
    public void populateLibrary(String file_songs, String file_movies, String file_movie_ratings)
    {
        ArrayList<Song> songs =  FileReader.readSongs(file_songs);
        ArrayList<Movie> movies = FileReader.readMovieRatings(FileReader.readMovies(file_movies), file_movie_ratings);

        this.masterRatableList.addAll(songs);
        this.masterRatableList.addAll(movies);

    }

    public ArrayList<Ratable> returnMasterList()
    {
        return this.masterRatableList;
    }

    public static int compareToDouble(double o, double r) {

        if (o == r)
            return 0;
        else if (o < r)
            return 1;
        else
            return -1;
    }
    public ArrayList<Ratable> topKRatables(int k) {

        ArrayList<Ratable> tempArr = this.masterRatableList;

        tempArr.sort((ratable1, ratable2)
                -> compareToDouble(ratable1.bayesianAverageRating(2, 3), ratable2.bayesianAverageRating(2, 3)));

        if (k < tempArr.size()) {
            ArrayList<Ratable> newArr = new ArrayList<Ratable>();

        for (int i = 0; i < k; i++) {
            newArr.add(tempArr.get(i));
        }
        return newArr;
    }
       else{
            return tempArr;
        }



    }


}



