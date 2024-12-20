package powerup.v1.usecases;

import powerup.v1.dtos.request.EmblemaTipoRequestDto;
import powerup.v1.dtos.response.EmblemaTipoResponseDto;
import powerup.v1.entities.EmblemaTipo;

import java.util.List;

public interface EmblemaTipoService {
    EmblemaTipoRequestDto create(EmblemaTipoResponseDto emblemaTipo);
    List<EmblemaTipoRequestDto> getAll();
    EmblemaTipoRequestDto getById(Integer id);
    EmblemaTipoRequestDto update(Integer id, EmblemaTipoResponseDto emblemaTipo);
    void delete(Integer id);
}
