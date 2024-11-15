package powerup.v1.usecases;

import powerup.v1.dtos.request.ModuloEducativoDto;
import powerup.v1.entities.ModuloEducativo;

import java.util.List;

public interface ModuloEducativoService {
    ModuloEducativoDto create(ModuloEducativo moduloEducativo);
    List<ModuloEducativoDto> getAll();
    ModuloEducativoDto getById(Integer id);
    ModuloEducativoDto update(Integer id, ModuloEducativo moduloEducativo);
    void delete(Integer id);
}
