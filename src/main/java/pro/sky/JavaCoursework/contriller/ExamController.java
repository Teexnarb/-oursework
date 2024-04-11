package pro.sky.JavaCoursework.contriller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.JavaCoursework.entity.Question;
import pro.sky.JavaCoursework.service.ExaminerService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    public Collection<Question> getQuestions(int amount)  {
        return examinerService.getQuestions(amount);
    }
}