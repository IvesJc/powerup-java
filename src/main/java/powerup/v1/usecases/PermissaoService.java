package powerup.v1.usecases;

import powerup.v1.dtos.request.PermissaoRequestDto;
import powerup.v1.entities.Permissao;

import java.util.List;

public interface PermissaoService {
    PermissaoRequestDto create(Permissao permissao);
    List<PermissaoRequestDto> getAll();
    PermissaoRequestDto getById(Integer id);
    PermissaoRequestDto update(Integer id, Permissao permissao);
    void delete(Integer id);
}
