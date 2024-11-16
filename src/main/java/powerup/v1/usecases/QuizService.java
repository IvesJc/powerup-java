package powerup.v1.usecases;

import powerup.v1.dtos.request.QuizRequestDto;
import powerup.v1.entities.Quiz;

import java.util.List;

public interface QuizService {
    QuizRequestDto create(Quiz quiz);
    List<QuizRequestDto> getAll();
    QuizRequestDto getById(Integer id);
    QuizRequestDto update(Integer id, Quiz quiz);
    void delete(Integer id);
}
