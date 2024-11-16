package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.MissaoConfigRequestDto;
import powerup.v1.entities.MissaoConfig;
import powerup.v1.repositories.MissaoConfigRepository;
import powerup.v1.usecases.MissaoConfigService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissaoConfigServiceImpl implements MissaoConfigService {
    private final MissaoConfigRepository missaoConfigRepository;


    @Override
    public MissaoConfigRequestDto create(MissaoConfig missaoConfig) {
        MissaoConfig savedEntity = missaoConfigRepository.save(missaoConfig);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<MissaoConfigRequestDto> getAll() {
        return missaoConfigRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MissaoConfigRequestDto getById(Integer id) {
        return missaoConfigRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("MissaoConfig not found with id: " + id));
    }

    @Override
    public MissaoConfigRequestDto update(Integer id, MissaoConfig missaoConfig) {
        if (!missaoConfigRepository.existsById(id)) {
            throw new IdNotFoundException("MissaoConfig not found with id: " + id);
        }
        missaoConfig.setId(id);
        MissaoConfig updatedEntity = missaoConfigRepository.save(missaoConfig);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!missaoConfigRepository.existsById(id)) {
            throw new IdNotFoundException("MissaoConfig not found with id: " + id);
        }
        missaoConfigRepository.deleteById(id);
    }

    private MissaoConfigRequestDto mapToDTO(MissaoConfig missaoConfig) {
        return MissaoConfigRequestDto.builder()
                .id(missaoConfig.getId())
                .nome(missaoConfig.getNome())
                .descricao(missaoConfig.getDescricao())
                .pontos(missaoConfig.getPontos())
                .frequenciaDias(missaoConfig.getFrequenciaDias())
                .build();
    }
}
