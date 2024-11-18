package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.QuizRequestDto;
import powerup.v1.dtos.response.QuizResponseDto;
import powerup.v1.entities.ModuloEducativo;
import powerup.v1.entities.Quiz;
import powerup.v1.repositories.ModuloEducativoRepository;
import powerup.v1.repositories.QuizRepository;
import powerup.v1.usecases.QuizService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;
    private final ModuloEducativoRepository moduloEducativoRepository;

    @Override
    public QuizRequestDto create(QuizResponseDto quiz) {

        ModuloEducativo moduloEducativo = moduloEducativoRepository.findById(quiz.moduloEducativo()).orElseThrow(() -> new IdNotFoundException("ModuloEducativo not found"));

        Quiz savedEntity = Quiz.builder()
                .nome(quiz.nome())
                .descricao(quiz.descricao())
                .categoria(quiz.categoria())
                .notaMinima(quiz.notaMinima())
                .moduloEducativo(moduloEducativo).build();

        quizRepository.save(savedEntity);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<QuizRequestDto> getAll() {
        return quizRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QuizRequestDto getById(Integer id) {
        return quizRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Quiz not found with id: " + id));
    }

    @Override
    public QuizRequestDto update(Integer id, QuizResponseDto quiz) {
        ModuloEducativo moduloEducativo = moduloEducativoRepository.findById(quiz.moduloEducativo()).orElseThrow(() -> new IdNotFoundException("ModuloEducativo not found"));

        Quiz updatedEntity = quizRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Quiz not found with id: " + id));

        updatedEntity.setNome(quiz.nome());
        updatedEntity.setDescricao(quiz.descricao());
        updatedEntity.setCategoria(quiz.categoria());
        updatedEntity.setNotaMinima(quiz.notaMinima());
        updatedEntity.setModuloEducativo(moduloEducativo);

        quizRepository.save(updatedEntity);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!quizRepository.existsById(id)) {
            throw new IdNotFoundException("Quiz not found with id: " + id);
        }
        quizRepository.deleteById(id);
    }

    private QuizRequestDto mapToDTO(Quiz quiz) {
        return QuizRequestDto.builder()
                .id(quiz.getId())
                .nome(quiz.getNome())
                .descricao(quiz.getDescricao())
                .categoria(quiz.getCategoria())
                .notaMinima(quiz.getNotaMinima())
                .moduloEducativo(quiz.getModuloEducativo().getId())
                .build();
    }
}
