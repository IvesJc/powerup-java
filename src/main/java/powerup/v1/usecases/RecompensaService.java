package powerup.v1.usecases;

import powerup.v1.dtos.request.RecompensaConfigDto;
import powerup.v1.dtos.request.RecompensaDto;
import powerup.v1.entities.Recompensa;
import powerup.v1.entities.RecompensaConfig;

import java.util.List;

public interface RecompensaService {
    RecompensaDto create(Recompensa recompensa);
    List<RecompensaDto> getAll();
    RecompensaDto getById(Integer id);
    RecompensaDto update(Integer id, Recompensa recompensa);
    void delete(Integer id);
}
