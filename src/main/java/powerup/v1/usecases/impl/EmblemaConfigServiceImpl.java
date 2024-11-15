package powerup.v1.usecases.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.EmblemaConfigDto;
import powerup.v1.entities.EmblemaConfig;
import powerup.v1.repositories.EmblemaConfigRepository;
import powerup.v1.usecases.EmblemaConfigService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmblemaConfigServiceImpl implements EmblemaConfigService {
    private final EmblemaConfigRepository emblemaConfigRepository;

    @Override
    public EmblemaConfigDto create(EmblemaConfig emblemaConfig) {
        EmblemaConfig savedEntity = emblemaConfigRepository.save(emblemaConfig);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<EmblemaConfigDto> getAll() {
        return emblemaConfigRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmblemaConfigDto getById(Integer id) {
        return emblemaConfigRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("EmblemaConfig not found with id: " + id));
    }

    @Override
    public EmblemaConfigDto update(Integer id, EmblemaConfig emblemaConfig) {
        if (!emblemaConfigRepository.existsById(id)) {
            throw new EntityNotFoundException("EmblemaConfig not found with id: " + id);
        }
        emblemaConfig.setId(id);
        EmblemaConfig updatedEntity = emblemaConfigRepository.save(emblemaConfig);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!emblemaConfigRepository.existsById(id)) {
            throw new EntityNotFoundException("EmblemaConfig not found with id: " + id);
        }
        emblemaConfigRepository.deleteById(id);
    }

    private EmblemaConfigDto mapToDTO(EmblemaConfig emblemaConfig) {
        return EmblemaConfigDto.builder()
                .id(emblemaConfig.getId())
                .nome(emblemaConfig.getNome())
                .descricao(emblemaConfig.getDescricao())
                .emblemaTipo(emblemaConfig.getEmblemaTipoId().getId())
                .quiz(emblemaConfig.getQuizId().getId())
                .build();
    }
}



