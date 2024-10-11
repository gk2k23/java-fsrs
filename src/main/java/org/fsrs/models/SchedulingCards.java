package org.fsrs.models;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class SchedulingCards {
    public Card again;
    public Card hard;
    public Card good;
    public Card easy;

    public SchedulingCards(Card card) {
        this.again = new Card(card.getDue(), card.getStability(), card.getDifficulty(), card.getElapsedDays(),
                card.getScheduledDays(), card.getReps(), card.getLapses(), card.getState(), card.getLastReview());
        this.hard = new Card(card.getDue(), card.getStability(), card.getDifficulty(), card.getElapsedDays(),
                card.getScheduledDays(), card.getReps(), card.getLapses(), card.getState(), card.getLastReview());
        this.good = new Card(card.getDue(), card.getStability(), card.getDifficulty(), card.getElapsedDays(),
                card.getScheduledDays(), card.getReps(), card.getLapses(), card.getState(), card.getLastReview());
        this.easy = new Card(card.getDue(), card.getStability(), card.getDifficulty(), card.getElapsedDays(),
                card.getScheduledDays(), card.getReps(), card.getLapses(), card.getState(), card.getLastReview());
    }

    public void updateState(State state) {
        if (state == State.NEW) {
            again.setState(State.LEARNING);
            hard.setState(State.LEARNING);
            good.setState(State.LEARNING);
            easy.setState(State.REVIEW);
        } else if (state == State.LEARNING || state == State.RELEARNING) {
            again.setState(state);
            hard.setState(state);
            good.setState(State.REVIEW);
            easy.setState(State.REVIEW);
        } else if (state == State.REVIEW) {
            again.setState(State.RELEARNING);
            hard.setState(State.REVIEW);
            good.setState(State.REVIEW);
            easy.setState(State.REVIEW);
            again.setLapses(again.getLapses() + 1);
        }
    }

    public void schedule(Instant now, int hardInterval, int goodInterval, int easyInterval) {
        again.setScheduledDays(0);
        hard.setScheduledDays(hardInterval);
        good.setScheduledDays(goodInterval);
        easy.setScheduledDays(easyInterval);
        again.setDue(now.plus(5, ChronoUnit.MINUTES));
        if (hardInterval > 0) {
            hard.setDue(now.plus(hardInterval, ChronoUnit.DAYS));
        } else {
            hard.setDue(now.plus(10, ChronoUnit.MINUTES));
        }
        good.setDue(now.plus(goodInterval, ChronoUnit.DAYS));
        easy.setDue(now.plus(easyInterval, ChronoUnit.DAYS));
    }

    public Map<Rating, SchedulingInfo> recordLog(Card card, Instant now) {
        Map<Rating, SchedulingInfo> result = new HashMap<>();
        result.put(Rating.AGAIN, new SchedulingInfo(again, new ReviewLog(Rating.AGAIN, again.getScheduledDays(), card.getElapsedDays(), now, card.getState())));
        result.put(Rating.HARD, new SchedulingInfo(hard, new ReviewLog(Rating.HARD, hard.getScheduledDays(), card.getElapsedDays(), now, card.getState())));
        result.put(Rating.GOOD, new SchedulingInfo(good, new ReviewLog(Rating.GOOD, good.getScheduledDays(), card.getElapsedDays(), now, card.getState())));
        result.put(Rating.EASY, new SchedulingInfo(easy, new ReviewLog(Rating.EASY, easy.getScheduledDays(), card.getElapsedDays(), now, card.getState())));
        return result;
    }
}
