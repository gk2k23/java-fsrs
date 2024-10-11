package org.fsrs.models;


public enum State {
    NEW(0),
    LEARNING(1),
    REVIEW(2),
    RELEARNING(3);

    private final int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}