package model;

import java.util.Objects;

public class Question {

    private int id;
    private String text;
    private int pollId;


    public Question() {
    }

    public Question(int id, String text, int pollId) {
        this.id = id;
        this.text = text;
        this.pollId = pollId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id && pollId == question.pollId && Objects.equals(text, question.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, pollId);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", pollId=" + pollId +
                '}';
    }
}

