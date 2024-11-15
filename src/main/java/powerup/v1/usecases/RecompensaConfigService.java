package powerup.v1.usecases;

import powerup.v1.dtos.request.RecompensaConfigDto;
import powerup.v1.dtos.request.RecompensaTipoDto;
import powerup.v1.entities.RecompensaConfig;
import powerup.v1.entities.RecompensaTipo;

import java.util.List;

public interface RecompensaConfigService {
    RecompensaConfigDto create(RecompensaConfig recompensaConfig);
    List<RecompensaConfigDto> getAll();
    RecompensaConfigDto getById(Integer id);
    RecompensaConfigDto update(Integer id, RecompensaConfig recompensaConfig);
    void delete(Integer id);
}
