package powerup.v1.usecases.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.AlternativaDto;
import powerup.v1.entities.Alternativa;
import powerup.v1.repositories.AlternativaRepository;
import powerup.v1.usecases.AlternativaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlternativaServiceImpl implements AlternativaService {
    private final AlternativaRepository alternativaRepository;

    @Override
    public AlternativaDto create(Alternativa alternativa) {
        Alternativa savedEntity = alternativaRepository.save(alternativa);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<AlternativaDto> getAll() {
        return alternativaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AlternativaDto getById(Integer id) {
        return alternativaRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Alternativa not found with id: " + id));
    }

    @Override
    public AlternativaDto update(Integer id, Alternativa alternativa) {
        if (!alternativaRepository.existsById(id)) {
            throw new EntityNotFoundException("Alternativa not found with id: " + id);
        }
        alternativa.setId(id);
        Alternativa updatedEntity = alternativaRepository.save(alternativa);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!alternativaRepository.existsById(id)) {
            throw new EntityNotFoundException("Alternativa not found with id: " + id);
        }
        alternativaRepository.deleteById(id);
    }

    private AlternativaDto mapToDTO(Alternativa alternativa) {
        return AlternativaDto.builder()
                .id(alternativa.getId())
                .pergunta(alternativa.getPergunta().getId())
                .descricao(alternativa.getDescricao())
                .eCorreta(alternativa.getECorreta())
                .build();
    }
}
