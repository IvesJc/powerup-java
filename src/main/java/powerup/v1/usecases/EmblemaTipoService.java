package powerup.v1.usecases;

import powerup.v1.dtos.request.EmblemaTipoDto;
import powerup.v1.entities.EmblemaTipo;

import java.util.List;
import java.util.Optional;

public interface EmblemaTipoService {
    EmblemaTipoDto create(EmblemaTipo emblemaTipo);
    List<EmblemaTipoDto> getAll();
    EmblemaTipoDto getById(Integer id);
    EmblemaTipoDto update(Integer id, EmblemaTipo emblemaTipo);
    void delete(Integer id);
}
