package powerup.v1.usecases;

import powerup.v1.dtos.request.QuizRequestDto;
import powerup.v1.dtos.response.QuizResponseDto;
import powerup.v1.entities.Quiz;

import java.util.List;

public interface QuizService {
    QuizRequestDto create(QuizResponseDto quiz);
    List<QuizRequestDto> getAll();
    QuizRequestDto getById(Integer id);
    QuizRequestDto update(Integer id, QuizResponseDto quiz);
    void delete(Integer id);
}
