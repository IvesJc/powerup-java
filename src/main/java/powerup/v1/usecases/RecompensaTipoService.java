package powerup.v1.usecases;

import powerup.v1.dtos.request.RecompensaTipoDto;
import powerup.v1.entities.RecompensaTipo;

import java.util.List;
import java.util.Optional;

public interface RecompensaTipoService {
    RecompensaTipoDto create(RecompensaTipo recompensaTipo);
    List<RecompensaTipoDto> getAll();
    RecompensaTipoDto getById(Integer id);
    RecompensaTipoDto update(Integer id, RecompensaTipo recompensaTipo);
    void delete(Integer id);
}
