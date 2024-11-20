package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.EmblemaConfigRequestDto;
import powerup.v1.dtos.response.EmblemaConfigResponseDto;
import powerup.v1.entities.EmblemaConfig;
import powerup.v1.entities.EmblemaTipo;
import powerup.v1.entities.Quiz;
import powerup.v1.repositories.EmblemaConfigRepository;
import powerup.v1.repositories.EmblemaTipoRepository;
import powerup.v1.repositories.QuizRepository;
import powerup.v1.usecases.EmblemaConfigService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmblemaConfigServiceImpl implements EmblemaConfigService {
    private final EmblemaConfigRepository emblemaConfigRepository;
    private final EmblemaTipoRepository emblemaTipoRepository;
    private final QuizRepository quizRepository;

    @Override
    public EmblemaConfigRequestDto create(EmblemaConfigResponseDto emblemaConfig) {

        EmblemaTipo emblemaTipo = emblemaTipoRepository.findById(emblemaConfig.emblemaTipo()).orElseThrow(() -> new IdNotFoundException("EmblemaTipo not found with id: " + emblemaConfig.emblemaTipo()));

        Quiz quiz = quizRepository.findById(emblemaConfig.quiz()).orElseThrow(() -> new IdNotFoundException("Quiz not found with id: " + emblemaConfig.quiz()));

        EmblemaConfig newEmblemaConfig = EmblemaConfig.builder()
                .nome(emblemaConfig.nome())
                .descricao(emblemaConfig.descricao())
                .emblemaTipoId(emblemaTipo)
                .quizId(quiz).build();

        emblemaConfigRepository.save(newEmblemaConfig);
        return mapToDTO(newEmblemaConfig);
    }

    @Override
    public List<EmblemaConfigRequestDto> getAll() {
        return emblemaConfigRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmblemaConfigRequestDto getById(Integer id) {
        return emblemaConfigRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("EmblemaConfig not found with id: " + id));
    }

    @Override
    public EmblemaConfigRequestDto update(Integer id, EmblemaConfigResponseDto emblemaConfig) {

        EmblemaTipo emblemaTipo = emblemaTipoRepository.findById(emblemaConfig.emblemaTipo()).orElseThrow(() -> new IdNotFoundException("EmblemaTipo not found with id: " + emblemaConfig.emblemaTipo()));

        Quiz quiz = quizRepository.findById(emblemaConfig.quiz()).orElseThrow(() -> new IdNotFoundException("Quiz not found with id: " + emblemaConfig.quiz()));

        EmblemaConfig updateEmblemaConfig = emblemaConfigRepository.findById(id).orElseThrow(() -> new IdNotFoundException("EmblemaConfig not found with id: " + id));

        updateEmblemaConfig.setNome(emblemaConfig.nome());
        updateEmblemaConfig.setDescricao(emblemaConfig.descricao());
        updateEmblemaConfig.setEmblemaTipoId(emblemaTipo);
        updateEmblemaConfig.setQuizId(quiz);

        emblemaConfigRepository.save(updateEmblemaConfig);
        return mapToDTO(updateEmblemaConfig);
    }

    @Override
    public void delete(Integer id) {
        if (!emblemaConfigRepository.existsById(id)) {
            throw new IdNotFoundException("EmblemaConfig not found with id: " + id);
        }
        emblemaConfigRepository.deleteById(id);
    }

    private EmblemaConfigRequestDto mapToDTO(EmblemaConfig emblemaConfig) {
        return EmblemaConfigRequestDto.builder()
                .id(emblemaConfig.getId())
                .nome(emblemaConfig.getNome())
                .descricao(emblemaConfig.getDescricao())
                .emblemaTipo(emblemaConfig.getEmblemaTipoId().getId())
                .quiz(emblemaConfig.getQuizId().getId())
                .build();
    }
}



