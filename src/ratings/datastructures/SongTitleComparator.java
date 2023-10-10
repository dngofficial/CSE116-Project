package ratings.datastructures;

import ratings.Song;
public class SongTitleComparator extends Comparator<Song> {
    //return true if a comes before b and false otherwise
    @Override
    public boolean compare(Song a, Song b) {

        int val_result = a.getTitle().compareToIgnoreCase(b.getTitle());

        return false; //not sure how to convert the int values into the true/false statement yet
    }
}
