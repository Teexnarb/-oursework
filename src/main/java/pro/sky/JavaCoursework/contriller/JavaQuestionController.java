package pro.sky.JavaCoursework.contriller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.sky.JavaCoursework.entity.Question;
import pro.sky.JavaCoursework.service.QuestionService;

import java.util.Collection;


@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    @Autowired
    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public void addQuestion(@RequestParam("question") String questionText, @RequestParam("answer") String answerText) {
        questionService.addQuestion(questionText, answerText);
    }

    @DeleteMapping("/remove")
    public void removeQuestion(@RequestParam("question") String questionText, @RequestParam("answer") String answerText) {
        Question questionToRemove = new Question(questionText, answerText);
        questionService.removeQuestion(questionToRemove);
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

}
