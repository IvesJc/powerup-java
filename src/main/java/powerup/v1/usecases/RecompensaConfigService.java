package powerup.v1.usecases;

import powerup.v1.dtos.request.RecompensaConfigRequestDto;
import powerup.v1.dtos.response.RecompensaConfigResponseDto;
import powerup.v1.entities.RecompensaConfig;

import java.util.List;

public interface RecompensaConfigService {
    RecompensaConfigRequestDto create(RecompensaConfigResponseDto recompensaConfig);
    List<RecompensaConfigRequestDto> getAll();
    RecompensaConfigRequestDto getById(Integer id);
    RecompensaConfigRequestDto update(Integer id, RecompensaConfigResponseDto recompensaConfig);
    void delete(Integer id);
}
