package powerup.v1.usecases;

import powerup.v1.dtos.MissaoConfigDto;
import powerup.v1.entities.MissaoConfig;

import java.util.List;
import java.util.Optional;

public interface MissaoConfigService {
    MissaoConfigDto create(MissaoConfig missaoConfig);

    MissaoConfigDto update(MissaoConfig missaoConfig);

    Optional<MissaoConfig> getById(Long id);

    List<MissaoConfigDto> getAll();

    void delete(Long id);
}
