package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.PerguntaRequestDto;
import powerup.v1.entities.Pergunta;
import powerup.v1.repositories.PerguntaRepository;
import powerup.v1.usecases.PerguntaService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PerguntaServiceImpl implements PerguntaService {
    private final PerguntaRepository perguntaRepository;

    @Override
    public PerguntaRequestDto create(Pergunta pergunta) {
        Pergunta savedEntity = perguntaRepository.save(pergunta);
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
    public PerguntaRequestDto update(Integer id, Pergunta pergunta) {
        if (!perguntaRepository.existsById(id)) {
            throw new IdNotFoundException("Pergunta not found with id: " + id);
        }
        pergunta.setId(id);
        Pergunta updatedEntity = perguntaRepository.save(pergunta);
        return mapToDTO(updatedEntity);
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

