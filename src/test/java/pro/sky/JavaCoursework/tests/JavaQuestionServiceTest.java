package pro.sky.JavaCoursework.tests;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import pro.sky.JavaCoursework.entity.Question;
import pro.sky.JavaCoursework.service.JavaQuestionService;


import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaQuestionServiceTest {
    private JavaQuestionService questionService;

    @BeforeEach
    public void setUp() {
        questionService = new JavaQuestionService();
    }

    @Test
    public void add() {
        questionService.add("Where are you?", "I'm at home.");
        Collection<Question> questions =
                questionService.getAll();
        assertEquals(1, questions.size());
    }

    @Test
    public void removeQuestion() {
        questionService.add("Where are you?", "I'm at home.");
        Question question = questionService.getRandomQuestion();
        questionService.remove(question);
        Collection<Question> questions =
                questionService.getAll();
        assertTrue(questions.isEmpty());
    }

    @Test
    public void getAllQuestions() {
        questionService.add("Where are you?", "I'm at home.");
        Collection<Question> questions = questionService.getAll();
        assertEquals(1,questions.size());
    }

    @Test
    public void getRandomQuestion() {
        questionService.add("Where are you?", "I'm at home.");
        questionService.add("How are you?", "I'm fine.");
        Collection<Question> questions = questionService.getAll();
        assertEquals(2, questions.size());
    }

}