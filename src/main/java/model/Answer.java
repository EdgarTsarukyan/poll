package model;

import java.util.Objects;


public class Answer {

    private int id;
    private String text;
    private int weight;
    private int questionId;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Answer(int id, String text, int weight, int questionId) {
        this.id = id;
        this.text = text;
        this.weight = weight;
        this.questionId = questionId;
    }

    public Answer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id == answer.id && weight == answer.weight && questionId == answer.questionId && Objects.equals(text, answer.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, weight, questionId);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", weight=" + weight +
                ", questionId=" + questionId +
                '}';
    }
}
