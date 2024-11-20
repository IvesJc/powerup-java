package powerup.v1.usecases;

import powerup.v1.dtos.request.PermissaoRequestDto;
import powerup.v1.dtos.response.PermissaoResponseDto;
import powerup.v1.entities.Permissao;

import java.util.List;

public interface PermissaoService {
    PermissaoRequestDto create(PermissaoResponseDto permissao);
    List<PermissaoRequestDto> getAll();
    PermissaoRequestDto getById(Integer id);
    PermissaoRequestDto update(Integer id, PermissaoResponseDto permissao);
    void delete(Integer id);
}
