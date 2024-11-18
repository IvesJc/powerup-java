package powerup.v1.usecases;

import powerup.v1.dtos.request.EmblemaConfigRequestDto;
import powerup.v1.dtos.response.EmblemaConfigResponseDto;
import powerup.v1.entities.EmblemaConfig;

import java.util.List;

public interface EmblemaConfigService {
    EmblemaConfigRequestDto create(EmblemaConfigResponseDto emblemaConfig);
    List<EmblemaConfigRequestDto> getAll();
    EmblemaConfigRequestDto getById(Integer id);
    EmblemaConfigRequestDto update(Integer id, EmblemaConfigResponseDto emblemaConfig);
    void delete(Integer id);
}
