package powerup.v1.usecases;

import powerup.v1.dtos.request.EmblemaConfigDto;
import powerup.v1.dtos.request.EmblemaTipoDto;
import powerup.v1.entities.EmblemaConfig;
import powerup.v1.entities.EmblemaTipo;

import java.util.List;
import java.util.Optional;

public interface EmblemaConfigService {
    EmblemaConfigDto create(EmblemaConfig emblemaConfig);
    List<EmblemaConfigDto> getAll();
    EmblemaConfigDto getById(Integer id);
    EmblemaConfigDto update(Integer id, EmblemaConfig emblemaConfig);
    void delete(Integer id);
}
