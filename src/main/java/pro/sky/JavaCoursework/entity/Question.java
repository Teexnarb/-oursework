package pro.sky.JavaCoursework.entity;

import java.util.Objects;

public class Question {
    String questions;
    String answer;

    public String getQuestions() {
        return questions;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestions(String questions) {
        questions = questions;
    }

    public void setAnswer(String answer) {
        answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "Questions='" + questions + '\'' +
                ", Answer='" + answer + '\'' +
                '}';
    }

    public Question(String questions, String answers) {
        questions = questions;
        answer = answers;
    }
}