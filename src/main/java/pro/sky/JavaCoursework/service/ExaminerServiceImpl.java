package pro.sky.JavaCoursework.service;


import org.springframework.stereotype.Service;
import pro.sky.JavaCoursework.entity.Question;
import pro.sky.JavaCoursework.exception.QuestionLimitException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public HashSet<Question> getQuestions(int count) {
        Collection<Question> questions = questionService.getAllQuestions();
        int questionsSize = questions.size();
        if (questionsSize < count) {
            throw new QuestionLimitException(String.format("", count, questionsSize));
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < count) {
            result.add(questionService.getRandomQuestion());
        }
        return (HashSet<Question>) result;
    }
}
