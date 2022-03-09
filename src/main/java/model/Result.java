package model;

import java.util.Objects;

public class Result {

    private int id;
    private String explanation;
    private int minScore;
    private int maxScore;
    private int pollId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getMinScore() {
        return minScore;
    }

    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    public Result(int id, String explanation, int minimum, int maxScore, int pollId) {
        this.id = id;
        this.explanation = explanation;
        this.minScore = minimum;
        this.maxScore = maxScore;
        this.pollId = pollId;
    }

    public Result() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return id == result.id && minScore == result.minScore && maxScore == result.maxScore && pollId == result.pollId && Objects.equals(explanation, result.explanation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, explanation, minScore, maxScore, pollId);
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", explanation='" + explanation + '\'' +
                ", minScore=" + minScore +
                ", maxScore=" + maxScore +
                ", pollId=" + pollId +
                '}';
    }
}
