package powerup.v1.usecases;

import powerup.v1.dtos.request.EmblemaConfigRequestDto;
import powerup.v1.entities.EmblemaConfig;

import java.util.List;

public interface EmblemaConfigService {
    EmblemaConfigRequestDto create(EmblemaConfig emblemaConfig);
    List<EmblemaConfigRequestDto> getAll();
    EmblemaConfigRequestDto getById(Integer id);
    EmblemaConfigRequestDto update(Integer id, EmblemaConfig emblemaConfig);
    void delete(Integer id);
}
