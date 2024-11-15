package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.RecompensaConfigDto;
import powerup.v1.entities.RecompensaConfig;
import powerup.v1.repositories.RecompensaConfigRepository;
import powerup.v1.usecases.RecompensaConfigService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecompensaConfigServiceImpl implements RecompensaConfigService {
    private final RecompensaConfigRepository recompensaConfigRepository;

    @Override
    public RecompensaConfigDto create(RecompensaConfig recompensaConfig) {
        RecompensaConfig savedEntity = recompensaConfigRepository.save(recompensaConfig);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<RecompensaConfigDto> getAll() {
        return recompensaConfigRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecompensaConfigDto getById(Integer id) {
        return recompensaConfigRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("RecompensaConfig not found with id: " + id));
    }

    @Override
    public RecompensaConfigDto update(Integer id, RecompensaConfig recompensaConfig) {
        if (!recompensaConfigRepository.existsById(id)) {
            throw new IdNotFoundException("RecompensaConfig not found with id: " + id);
        }
        recompensaConfig.setId(id);
        RecompensaConfig updatedEntity = recompensaConfigRepository.save(recompensaConfig);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!recompensaConfigRepository.existsById(id)) {
            throw new IdNotFoundException("RecompensaConfig not found with id: " + id);
        }
        recompensaConfigRepository.deleteById(id);
    }

    private RecompensaConfigDto mapToDTO(RecompensaConfig recompensaConfig) {
        return RecompensaConfigDto.builder()
                .id(recompensaConfig.getId())
                .nome(recompensaConfig.getNome())
                .custoPontos(recompensaConfig.getCustoPontos())
                .recompensaTipo(recompensaConfig.getRecompensaTipo().getId())
                .build();
    }
}


