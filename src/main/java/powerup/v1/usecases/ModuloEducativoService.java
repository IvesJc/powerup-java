package powerup.v1.usecases;

import powerup.v1.dtos.request.ModuloEducativoRequestDto;
import powerup.v1.entities.ModuloEducativo;

import java.util.List;

public interface ModuloEducativoService {
    ModuloEducativoRequestDto create(ModuloEducativo moduloEducativo);
    List<ModuloEducativoRequestDto> getAll();
    ModuloEducativoRequestDto getById(Integer id);
    ModuloEducativoRequestDto update(Integer id, ModuloEducativo moduloEducativo);
    void delete(Integer id);
}
