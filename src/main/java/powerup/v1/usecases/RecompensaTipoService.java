package powerup.v1.usecases;

import powerup.v1.dtos.request.RecompensaTipoRequestDto;
import powerup.v1.entities.RecompensaTipo;

import java.util.List;

public interface RecompensaTipoService {
    RecompensaTipoRequestDto create(RecompensaTipo recompensaTipo);
    List<RecompensaTipoRequestDto> getAll();
    RecompensaTipoRequestDto getById(Integer id);
    RecompensaTipoRequestDto update(Integer id, RecompensaTipo recompensaTipo);
    void delete(Integer id);
}
