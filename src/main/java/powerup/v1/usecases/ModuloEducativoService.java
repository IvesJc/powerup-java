package powerup.v1.usecases;

import powerup.v1.dtos.request.ModuloEducativoRequestDto;
import powerup.v1.dtos.response.ModuloEducativoResponseDto;
import powerup.v1.entities.ModuloEducativo;

import java.util.List;

public interface ModuloEducativoService {
    ModuloEducativoRequestDto create(ModuloEducativoResponseDto moduloEducativo);
    List<ModuloEducativoRequestDto> getAll();
    ModuloEducativoRequestDto getById(Integer id);
    ModuloEducativoRequestDto update(Integer id, ModuloEducativoResponseDto moduloEducativo);
    void delete(Integer id);
}
