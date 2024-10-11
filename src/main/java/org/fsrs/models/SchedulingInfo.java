package org.fsrs.models;

public class SchedulingInfo {
    public Card card;
    public ReviewLog reviewLog;

    public SchedulingInfo(Card card, ReviewLog reviewLog) {
        this.card = card;
        this.reviewLog = reviewLog;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public ReviewLog getReviewLog() {
        return reviewLog;
    }

    public void setReviewLog(ReviewLog reviewLog) {
        this.reviewLog = reviewLog;
    }
}
