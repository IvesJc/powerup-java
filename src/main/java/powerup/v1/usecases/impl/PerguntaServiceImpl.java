package powerup.v1.usecases.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.PerguntaDto;
import powerup.v1.entities.Pergunta;
import powerup.v1.repositories.PerguntaRepository;
import powerup.v1.usecases.PerguntaService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PerguntaServiceImpl implements PerguntaService {
    private final PerguntaRepository perguntaRepository;

    @Override
    public PerguntaDto create(Pergunta pergunta) {
        Pergunta savedEntity = perguntaRepository.save(pergunta);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<PerguntaDto> getAll() {
        return perguntaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PerguntaDto getById(Integer id) {
        return perguntaRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Pergunta not found with id: " + id));
    }

    @Override
    public PerguntaDto update(Integer id, Pergunta pergunta) {
        if (!perguntaRepository.existsById(id)) {
            throw new EntityNotFoundException("Pergunta not found with id: " + id);
        }
        pergunta.setId(id);
        Pergunta updatedEntity = perguntaRepository.save(pergunta);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!perguntaRepository.existsById(id)) {
            throw new EntityNotFoundException("Pergunta not found with id: " + id);
        }
        perguntaRepository.deleteById(id);
    }

    private PerguntaDto mapToDTO(Pergunta pergunta) {
        return PerguntaDto.builder()
                .id(pergunta.getId())
                .titulo(pergunta.getTitulo())
                .conteudo(pergunta.getConteudo())
                .quiz(pergunta.getQuizId().getId())
                .build();
    }
}

