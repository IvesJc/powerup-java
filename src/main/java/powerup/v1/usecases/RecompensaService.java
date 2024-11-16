package powerup.v1.usecases;

import powerup.v1.dtos.request.RecompensaRequestDto;
import powerup.v1.entities.Recompensa;

import java.util.List;

public interface RecompensaService {
    RecompensaRequestDto create(Recompensa recompensa);
    List<RecompensaRequestDto> getAll();
    RecompensaRequestDto getById(Integer id);
    RecompensaRequestDto update(Integer id, Recompensa recompensa);
    void delete(Integer id);
}
