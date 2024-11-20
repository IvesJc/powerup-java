package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.PerguntaRequestDto;
import powerup.v1.dtos.response.PerguntaResponseDto;
import powerup.v1.entities.Pergunta;
import powerup.v1.entities.Quiz;
import powerup.v1.repositories.PerguntaRepository;
import powerup.v1.repositories.QuizRepository;
import powerup.v1.usecases.PerguntaService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PerguntaServiceImpl implements PerguntaService {
    private final PerguntaRepository perguntaRepository;
    private final QuizRepository quizRepository;

    @Override
    public PerguntaRequestDto create(PerguntaResponseDto pergunta) {

        Quiz quiz = quizRepository.findById(pergunta.quiz()).orElseThrow(() -> new IdNotFoundException("Quiz not found with id: " + pergunta.quiz()));

        Pergunta savedEntity = Pergunta.builder()
                .titulo(pergunta.titulo())
                .conteudo(pergunta.conteudo())
                .quizId(quiz).build();
        perguntaRepository.save(savedEntity);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<PerguntaRequestDto> getAll() {
        return perguntaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PerguntaRequestDto getById(Integer id) {
        return perguntaRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Pergunta not found with id: " + id));
    }

    @Override
    public PerguntaRequestDto update(Integer id, PerguntaResponseDto pergunta) {

        Quiz quiz = quizRepository.findById(pergunta.quiz()).orElseThrow(() -> new IdNotFoundException("Quiz not found with id: " + pergunta.quiz()));

        Pergunta updatePergunta = perguntaRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Pergunta not found with id: " + id));

        updatePergunta.setTitulo(pergunta.titulo());
        updatePergunta.setConteudo(pergunta.conteudo());
        updatePergunta.setQuizId(quiz);

        perguntaRepository.save(updatePergunta);
        return mapToDTO(updatePergunta);
    }

    @Override
    public void delete(Integer id) {
        if (!perguntaRepository.existsById(id)) {
            throw new IdNotFoundException("Pergunta not found with id: " + id);
        }
        perguntaRepository.deleteById(id);
    }

    private PerguntaRequestDto mapToDTO(Pergunta pergunta) {
        return PerguntaRequestDto.builder()
                .id(pergunta.getId())
                .titulo(pergunta.getTitulo())
                .conteudo(pergunta.getConteudo())
                .quiz(pergunta.getQuizId().getId())
                .build();
    }
}

