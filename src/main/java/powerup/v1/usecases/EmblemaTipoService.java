package powerup.v1.usecases;

import powerup.v1.dtos.EmblemaTipoDto;
import powerup.v1.entities.EmblemaTipo;

import java.util.List;
import java.util.Optional;

public interface EmblemaTipoService {
    EmblemaTipoDto create(EmblemaTipo emblemaTipo);

    Optional<EmblemaTipoDto> getById(Long id);

    List<EmblemaTipoDto> getAll();
}
