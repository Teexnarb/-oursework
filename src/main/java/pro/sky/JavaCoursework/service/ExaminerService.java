package pro.sky.JavaCoursework.service;

import pro.sky.JavaCoursework.entity.Question;

import java.util.Collection;

public interface ExaminerService {
        Collection<Question> getQuestions(int amount);
}
