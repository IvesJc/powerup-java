package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.EmblemaConfigRequestDto;
import powerup.v1.entities.EmblemaConfig;
import powerup.v1.repositories.EmblemaConfigRepository;
import powerup.v1.usecases.EmblemaConfigService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmblemaConfigServiceImpl implements EmblemaConfigService {
    private final EmblemaConfigRepository emblemaConfigRepository;

    @Override
    public EmblemaConfigRequestDto create(EmblemaConfig emblemaConfig) {
        EmblemaConfig savedEntity = emblemaConfigRepository.save(emblemaConfig);
        return mapToDTO(savedEntity);
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
    public EmblemaConfigRequestDto update(Integer id, EmblemaConfig emblemaConfig) {
        if (!emblemaConfigRepository.existsById(id)) {
            throw new IdNotFoundException("EmblemaConfig not found with id: " + id);
        }
        emblemaConfig.setId(id);
        EmblemaConfig updatedEntity = emblemaConfigRepository.save(emblemaConfig);
        return mapToDTO(updatedEntity);
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



