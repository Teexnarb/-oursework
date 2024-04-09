package pro.sky.JavaCoursework.service;

import org.springframework.stereotype.Service;
import pro.sky.JavaCoursework.entity.Question;
import pro.sky.JavaCoursework.exception.QuestionLimitException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> allQuestion = questionService.getAll();
        int allQuestionSize = allQuestion.size();
        if (allQuestionSize < amount) {
            throw new QuestionLimitException(String.format(" ", amount, allQuestionSize));
        }

        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }

}
