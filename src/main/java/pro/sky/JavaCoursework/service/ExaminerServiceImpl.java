package pro.sky.JavaCoursework.service;


import org.springframework.stereotype.Service;
import pro.sky.JavaCoursework.entity.Question;
import pro.sky.JavaCoursework.exception.NotEnoughQuestions;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int count) {
        List<Question> questions = new ArrayList<>();

        while (questions.size() < count) {
            Question question = questionService.getRandomQuestion();

            if (!questions.contains(question)) {
                questions.add(question);
            }
        }

        if (questions.size() < count) {
            throw new NotEnoughQuestions("Вопросов получено недостаточное количество");
        }
        return questions;
    }
}
