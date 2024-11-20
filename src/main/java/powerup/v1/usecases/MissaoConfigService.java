package powerup.v1.usecases;

import powerup.v1.dtos.request.MissaoConfigRequestDto;
import powerup.v1.dtos.response.MissaoConfigResponseDto;
import powerup.v1.entities.MissaoConfig;

import java.util.List;

public interface MissaoConfigService {
    MissaoConfigRequestDto create(MissaoConfigResponseDto missaoConfig);
    List<MissaoConfigRequestDto> getAll();
    MissaoConfigRequestDto getById(Integer id);
    MissaoConfigRequestDto update(Integer id, MissaoConfigResponseDto missaoConfig);
    void delete(Integer id);
}
