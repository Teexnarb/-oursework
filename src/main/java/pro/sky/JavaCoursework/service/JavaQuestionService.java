package pro.sky.JavaCoursework.service;

import org.springframework.stereotype.Service;
import pro.sky.JavaCoursework.entity.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private List<Question> questions;

    public JavaQuestionService() {
        questions = new ArrayList<>();
    }

    @Override
    public void addQuestion(String text, String answer) {
        Question question = new Question(text, answer);
        questions.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }
}