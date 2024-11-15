package powerup.v1.usecases.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.MissaoConfigDto;
import powerup.v1.entities.MissaoConfig;
import powerup.v1.repositories.MissaoConfigRepository;
import powerup.v1.usecases.MissaoConfigService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissaoConfigServiceImpl implements MissaoConfigService {
    private final MissaoConfigRepository missaoConfigRepository;


    @Override
    public MissaoConfigDto create(MissaoConfig missaoConfig) {
        MissaoConfig savedEntity = missaoConfigRepository.save(missaoConfig);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<MissaoConfigDto> getAll() {
        return missaoConfigRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MissaoConfigDto getById(Integer id) {
        return missaoConfigRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("MissaoConfig not found with id: " + id));
    }

    @Override
    public MissaoConfigDto update(Integer id, MissaoConfig missaoConfig) {
        if (!missaoConfigRepository.existsById(id)) {
            throw new EntityNotFoundException("MissaoConfig not found with id: " + id);
        }
        missaoConfig.setId(id);
        MissaoConfig updatedEntity = missaoConfigRepository.save(missaoConfig);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!missaoConfigRepository.existsById(id)) {
            throw new EntityNotFoundException("MissaoConfig not found with id: " + id);
        }
        missaoConfigRepository.deleteById(id);
    }

    private MissaoConfigDto mapToDTO(MissaoConfig missaoConfig) {
        return MissaoConfigDto.builder()
                .id(missaoConfig.getId())
                .nome(missaoConfig.getNome())
                .descricao(missaoConfig.getDescricao())
                .pontos(missaoConfig.getPontos())
                .frequenciaDias(missaoConfig.getFrequenciaDias())
                .build();
    }
}
