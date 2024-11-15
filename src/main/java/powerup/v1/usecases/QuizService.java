package powerup.v1.usecases;

import powerup.v1.dtos.request.EmblemaTipoDto;
import powerup.v1.dtos.request.QuizDto;
import powerup.v1.entities.EmblemaTipo;
import powerup.v1.entities.Quiz;

import java.util.List;

public interface QuizService {
    QuizDto create(Quiz quiz);
    List<QuizDto> getAll();
    QuizDto getById(Integer id);
    QuizDto update(Integer id, Quiz quiz);
    void delete(Integer id);
}
