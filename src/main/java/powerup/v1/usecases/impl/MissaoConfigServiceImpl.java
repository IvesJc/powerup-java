package powerup.v1.usecases.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.MissaoConfigDto;
import powerup.v1.entities.MissaoConfig;
import powerup.v1.repositories.MissaoConfigRepository;
import powerup.v1.usecases.MissaoConfigService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoConfigServiceImpl implements MissaoConfigService {

    private final MissaoConfigRepository missaoConfigRepository;

    @Autowired
    public MissaoConfigServiceImpl(MissaoConfigRepository missaoConfigRepository) {
        this.missaoConfigRepository = missaoConfigRepository;
    }

    @Override
    public MissaoConfigDto create(MissaoConfig missaoConfig) {
        MissaoConfig savedConfig = missaoConfigRepository.save(missaoConfig);
        return new MissaoConfigDto(savedConfig.getId(), savedConfig.getNome(), savedConfig.getDescricao(), savedConfig.getPontos(), savedConfig.getFrequenciaDias());
    }

    @Override
    public MissaoConfigDto update(MissaoConfig missaoConfig) {
        MissaoConfig updatedConfig = missaoConfigRepository.save(missaoConfig);
        return new MissaoConfigDto(updatedConfig.getId(), updatedConfig.getNome(), updatedConfig.getDescricao(), updatedConfig.getPontos(), updatedConfig.getFrequenciaDias());
    }

    @Override
    public Optional<MissaoConfigDto> getById(Long id) {
        Optional<MissaoConfig> missaoConfig = missaoConfigRepository.findById(id);
        return missaoConfig.map(config -> new MissaoConfigDto(config.getId(), config.getNome(), config.getDescricao(), config.getPontos(), config.getFrequenciaDias()));
    }

    @Override
    public List<MissaoConfigDto> getAll() {
        return missaoConfigRepository.findAll().stream()
                .map(config -> new MissaoConfigDto(config.getId(), config.getNome(), config.getDescricao(), config.getPontos(), config.getFrequenciaDias()))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        missaoConfigRepository.deleteById(id);
    }
}