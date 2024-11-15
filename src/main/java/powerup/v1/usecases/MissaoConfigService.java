package powerup.v1.usecases;

import powerup.v1.dtos.request.MissaoConfigDto;
import powerup.v1.entities.MissaoConfig;

import java.util.List;
import java.util.Optional;

public interface MissaoConfigService {
    MissaoConfigDto create(MissaoConfig missaoConfig);
    List<MissaoConfigDto> getAll();
    MissaoConfigDto getById(Integer id);
    MissaoConfigDto update(Integer id, MissaoConfig missaoConfig);
    void delete(Integer id);
}
