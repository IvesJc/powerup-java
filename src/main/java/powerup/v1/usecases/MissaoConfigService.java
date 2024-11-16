package powerup.v1.usecases;

import powerup.v1.dtos.request.MissaoConfigRequestDto;
import powerup.v1.entities.MissaoConfig;

import java.util.List;

public interface MissaoConfigService {
    MissaoConfigRequestDto create(MissaoConfig missaoConfig);
    List<MissaoConfigRequestDto> getAll();
    MissaoConfigRequestDto getById(Integer id);
    MissaoConfigRequestDto update(Integer id, MissaoConfig missaoConfig);
    void delete(Integer id);
}
