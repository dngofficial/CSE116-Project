package ratings;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReader {
    public FileReader() {

    }

    public static ArrayList<Movie> readMovies(String filename) {

        try {
            ArrayList<Movie> return_arraylist = new ArrayList<Movie>();
            ArrayList<String> master_csv_lines = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            for (String unsplit_movie_list : master_csv_lines) {
                ArrayList<String> split_string_movie = new ArrayList<>(Arrays.asList(unsplit_movie_list.split(",")));
                ArrayList<String> movie_cast_list = new ArrayList<String>();
                String movie_title = " ";
                for (int i = 0; i < split_string_movie.size(); i++) {
                    if (i == 0) {
                        movie_title = split_string_movie.get(i);
                    } else {
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

     public static ArrayList<Song> readSongs(String filename) {
        try {
            ArrayList<Song> return_arraylist = new ArrayList<Song>();
            ArrayList<String> master_csv_lines = new ArrayList<>(Files.readAllLines(Paths.get(filename)));

            ArrayList<String> all_ids_scanned_already = new ArrayList<String>();
            for (String unsplit_movie_list : master_csv_lines) {

                ArrayList<String> split_string_song = new ArrayList<>(Arrays.asList(unsplit_movie_list.split(",")));
                String song_id = split_string_song.get(0);
                String song_artist = split_string_song.get(1);
                String song_title = split_string_song.get(2);

                if (!(all_ids_scanned_already.contains(song_id))) {

                    Song song = new Song(song_title, song_artist, song_id);

                    for (String unsplit_movie_list_2 : master_csv_lines) {
                        ArrayList<String> split_string_song_2 = new ArrayList<>(Arrays.asList(unsplit_movie_list_2.split(",")));
                        String song_reviewer_id = split_string_song_2.get(3);
                        int song_rating = Integer.parseInt(split_string_song_2.get(4));

                        if (song_id.equals(split_string_song_2.get(0))) {
                            song.addRating(new Rating(song_reviewer_id, song_rating));
                        }
                    }
                    all_ids_scanned_already.add(song_id);
                    return_arraylist.add(song);
                }
            }
            return return_arraylist;
            }
        catch(IOException e){
            System.out.println("failed");
                return new ArrayList<>();
            }

        }

        public static ArrayList<Movie> readMovieRatings(ArrayList<Movie> movie_list_1, String filename)
        {
            try {
                ArrayList<Movie> movie_list = movie_list_1;
            ArrayList<String> master_csv_lines = new ArrayList<>(Files.readAllLines(Paths.get(filename)));

                for (int i = movie_list.size() - 1; i >=0 ; i--) {
                    String movie_title = movie_list.get(i).getTitle();
                    boolean not_rated = true;

                    for (String unsplit_movie_list_lines : master_csv_lines) {
                        ArrayList<String> split_movie_list_lines = new ArrayList<>(Arrays.asList(unsplit_movie_list_lines.split(",")));

                        String temp_movie_title = split_movie_list_lines.get(0);
                        String mov_reviewer_id = split_movie_list_lines.get(1);
                        int movie_rating = Integer.parseInt(split_movie_list_lines.get(2));

                        if (temp_movie_title.equals(movie_title)) {
                            movie_list.get(i).addRating(new Rating(mov_reviewer_id, movie_rating));
                            not_rated = false;
                        }

                    }
                    if (not_rated) { movie_list.remove(i);}


                }

                return movie_list;


                }
            catch(IOException e){
                System.out.println("failed");
                return new ArrayList<>();
            }
        }

}



