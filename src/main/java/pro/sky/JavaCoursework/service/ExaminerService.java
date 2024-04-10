package pro.sky.JavaCoursework.service;

import org.apache.coyote.BadRequestException;
import pro.sky.JavaCoursework.entity.Question;

import java.util.List;

public interface ExaminerService {

        List<Question> getQuestions(int count) throws BadRequestException;
}