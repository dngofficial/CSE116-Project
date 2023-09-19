package ratings;

public class Rating {
    private String reviewer_id;
    private int rating;
    public Rating(String reviewer_id, int rating) {
        this.setReviewerID(reviewer_id);
        this.setRating(rating);
    }

    public String getReviewerID() {
        return this.reviewer_id;
    }

    public int getRating () {
        return this.rating;
    }

    public void setReviewerID(String reviewer_id){this.reviewer_id = reviewer_id;}

    public void setRating(int rating)
    {
        if (rating < 1 || rating > 5){
            this.rating = -1;
        }
        else {
                this.rating = rating;
        }
    }







}
