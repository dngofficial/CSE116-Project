package ratings.datastructures;

import ratings.Song;

public class SongBayesianRatingComparator extends Comparator<Song> {
    //return true if a comes before b and false otherwise
    @Override
    public boolean compare(Song a, Song b) {
        double rating_a = a.bayesianAverageRating(2,3);
        double rating_b = b.bayesianAverageRating(2,3);

        return rating_a > rating_b;
    }
}
