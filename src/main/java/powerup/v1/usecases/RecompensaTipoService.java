package powerup.v1.usecases;

import powerup.v1.dtos.LinkDto;
import powerup.v1.dtos.RecompensaTipoDto;
import powerup.v1.entities.Link;
import powerup.v1.entities.RecompensaTipo;

import java.util.List;
import java.util.Optional;

public interface RecompensaTipoService {
    RecompensaTipoDto create(RecompensaTipo recompensaTipo);

    Optional<RecompensaTipoDto> getById(Long id);

    List<RecompensaTipoDto> getAll();

    RecompensaTipoDto update(RecompensaTipo recompensaTipo);

    void delete(Long id);
}
