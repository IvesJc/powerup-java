package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.DesafioRequestDto;
import powerup.v1.dtos.response.DesafioResponseDto;
import powerup.v1.entities.Artigo;
import powerup.v1.entities.Desafio;
import powerup.v1.entities.Link;
import powerup.v1.entities.Quiz;
import powerup.v1.repositories.DesafioRepository;
import powerup.v1.repositories.LinkRepository;
import powerup.v1.repositories.QuizRepository;
import powerup.v1.usecases.DesafioService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DesafioServiceImpl implements DesafioService {
    private final DesafioRepository desafioRepository;
    private final LinkRepository linkRepository;
    private final QuizRepository quizRepository;

    @Override
    public DesafioRequestDto create(DesafioResponseDto desafio) {

        Link link = linkRepository.findById(desafio.thumbLink()).orElseThrow(() -> new IdNotFoundException("Link not found with id: " + desafio.thumbLink()));

        Quiz quiz = quizRepository.findById(desafio.quiz()).orElseThrow(() -> new IdNotFoundException("Quiz not found with id: " + desafio.quiz()));

        Desafio newDesafio = Desafio.builder()
                .nome(desafio.nome())
                .descricao(desafio.descricao())
                .thumbLink(link)
                .quiz(quiz).build();

        desafioRepository.save(newDesafio);
        return mapToDTO(newDesafio);
    }

    @Override
    public List<DesafioRequestDto> getAll() {
        return desafioRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DesafioRequestDto getById(Integer id) {
        return desafioRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Desafio not found with id: " + id));
    }

    @Override
    public DesafioRequestDto update(Integer id, DesafioResponseDto desafio) {

        Desafio updateDesafio = desafioRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Desafio not found with id: " + id));

        Link link = linkRepository.findById(desafio.thumbLink()).orElseThrow(() -> new IdNotFoundException("Link not found with id: " + desafio.thumbLink()));

        Quiz quiz = quizRepository.findById(desafio.quiz()).orElseThrow(() -> new IdNotFoundException("Quiz not found with id: " + desafio.quiz()));

        updateDesafio.setNome(desafio.nome());
        updateDesafio.setDescricao(desafio.descricao());
        updateDesafio.setThumbLink(link);
        updateDesafio.setQuiz(quiz);

        desafioRepository.save(updateDesafio);
        return mapToDTO(updateDesafio);
    }

    @Override
    public void delete(Integer id) {
        if (!desafioRepository.existsById(id)) {
            throw new IdNotFoundException("Desafio not found with id: " + id);
        }
        desafioRepository.deleteById(id);
    }

    private DesafioRequestDto mapToDTO(Desafio desafio) {
        return DesafioRequestDto.builder()
                .id(desafio.getId())
                .nome(desafio.getNome())
                .descricao(desafio.getDescricao())
                .thumbLink(desafio.getThumbLink().getId())
                .quiz(desafio.getQuiz().getId())
                .build();
    }
}


