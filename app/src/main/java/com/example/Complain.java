package com.example.nsucomplaintlodgementsystem;

public class Complain {
    private String again;
    private String dates;
    private String review;
    private String comp;

    public Complain(String again, String dates, String review, String comp) {
        this.again = again;
        this.dates = dates;
        this.review = review;
        this.comp = comp;
    }

    public String getAgain() {
        return again;
    }

    public void setAgain(String again) {
        this.again = again;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }
}
