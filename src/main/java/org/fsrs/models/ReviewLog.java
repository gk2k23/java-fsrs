package org.fsrs.models;

import java.time.Instant;

public class ReviewLog {
    private Rating rating;
    private int scheduledDays;
    private int elapsedDays;
    private Instant review;
    private State state;

    public ReviewLog(Rating rating, int scheduledDays, int elapsedDays, Instant review, State state) {
        this.rating = rating;
        this.scheduledDays = scheduledDays;
        this.elapsedDays = elapsedDays;
        this.review = review;
        this.state = state;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getScheduledDays() {
        return scheduledDays;
    }

    public void setScheduledDays(int scheduledDays) {
        this.scheduledDays = scheduledDays;
    }

    public int getElapsedDays() {
        return elapsedDays;
    }

    public void setElapsedDays(int elapsedDays) {
        this.elapsedDays = elapsedDays;
    }

    public Instant getReview() {
        return review;
    }

    public void setReview(Instant review) {
        this.review = review;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
