package ratings;

public class Reviewer {
    private String reviewer_id;
    public Reviewer(String reviewer_id) {
        this.setReviewerID(reviewer_id);
    }

    public String getReviewerID() {
        return this.reviewer_id;
    }
    public void setReviewerID(String reviewer_id){this.reviewer_id = reviewer_id;}



}
