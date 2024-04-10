package pro.sky.JavaCoursework.tests;


import org.apache.coyote.BadRequestException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import pro.sky.JavaCoursework.entity.Question;
import pro.sky.JavaCoursework.service.ExaminerService;
import pro.sky.JavaCoursework.service.ExaminerServiceImpl;
import pro.sky.JavaCoursework.service.QuestionService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class ExamAppApplicationTests {
    private QuestionService questionService;
    private ExaminerService examinerService;

    @BeforeEach
    void setUp() {
        questionService = mock(QuestionService.class);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void getQuestions_withException() throws BadRequestException {
        Question question1 = new Question("Question 1", "answer 1");
        Question question2 = new Question("Question 2", "answer 2");
        when(questionService.getRandomQuestion()).thenReturn(question1, question2);

        List<Question> result = examinerService.getQuestions(2);

        assertEquals(Arrays.asList(question1, question2), result);
        verify(questionService, times(2)).getRandomQuestion();
    }

    @Test
    void getQuestions_success() {

        when(questionService.getRandomQuestion()).thenReturn(new Question("Question 1", "answer 2"));

        assertThrows(BadRequestException.class, () -> examinerService.getQuestions(2));
        verify(questionService, atLeast(2)).getRandomQuestion();
    }
}