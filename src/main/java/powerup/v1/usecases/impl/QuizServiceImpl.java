package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.QuizDto;
import powerup.v1.entities.Quiz;
import powerup.v1.repositories.QuizRepository;
import powerup.v1.usecases.QuizService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;

    @Override
    public QuizDto create(Quiz quiz) {
        Quiz savedEntity = quizRepository.save(quiz);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<QuizDto> getAll() {
        return quizRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QuizDto getById(Integer id) {
        return quizRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Quiz not found with id: " + id));
    }

    @Override
    public QuizDto update(Integer id, Quiz quiz) {
        if (!quizRepository.existsById(id)) {
            throw new IdNotFoundException("Quiz not found with id: " + id);
        }
        quiz.setId(id);
        Quiz updatedEntity = quizRepository.save(quiz);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!quizRepository.existsById(id)) {
            throw new IdNotFoundException("Quiz not found with id: " + id);
        }
        quizRepository.deleteById(id);
    }

    private QuizDto mapToDTO(Quiz quiz) {
        return QuizDto.builder()
                .id(quiz.getId())
                .nome(quiz.getNome())
                .descricao(quiz.getDescricao())
                .categoria(quiz.getCategoria())
                .notaMinima(quiz.getNotaMinima())
                .moduloEducativo(quiz.getModuloEducativo().getId())
                .build();
    }
}
