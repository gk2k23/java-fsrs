package org.fsrs.models;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Card {
    private Instant due;
    private double stability;
    private double difficulty;
    private int elapsedDays;
    private int scheduledDays;
    private int reps;
    private int lapses;
    private State state;
    private Instant lastReview;

    public Card() {
        this.due = Instant.now();
        this.state = State.NEW;
    }

    public Card(Instant due, double stability, double difficulty, int elapsedDays, int scheduledDays,
                int reps, int lapses, State state, Instant lastReview) {
        this.due = due;
        this.stability = stability;
        this.difficulty = difficulty;
        this.elapsedDays = elapsedDays;
        this.scheduledDays = scheduledDays;
        this.reps = reps;
        this.lapses = lapses;
        this.state = state;
        this.lastReview = lastReview;
    }

    public double getRetrievability(Instant now) {
        final double DECAY = -0.5;
        final double FACTOR = Math.pow(0.9, 1 / DECAY) - 1;

        if (now == null) {
            now = Instant.now();
        }

        if (state == State.LEARNING || state == State.REVIEW || state == State.RELEARNING) {
            long elapsedDays = Math.max(0, Duration.between(lastReview, now).toDays());
            return Math.pow(1 + FACTOR * elapsedDays / stability, DECAY);
        } else {
            return 0;
        }
    }

    public Instant getDue() {
        return due;
    }

    public void setDue(Instant due) {
        this.due = due;
    }

    public double getStability() {
        return stability;
    }

    public void setStability(double stability) {
        this.stability = stability;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public int getElapsedDays() {
        return elapsedDays;
    }

    public void setElapsedDays(int elapsedDays) {
        this.elapsedDays = elapsedDays;
    }

    public int getScheduledDays() {
        return scheduledDays;
    }

    public void setScheduledDays(int scheduledDays) {
        this.scheduledDays = scheduledDays;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getLapses() {
        return lapses;
    }

    public void setLapses(int lapses) {
        this.lapses = lapses;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Instant getLastReview() {
        return lastReview;
    }

    public void setLastReview(Instant lastReview) {
        this.lastReview = lastReview;
    }
}
