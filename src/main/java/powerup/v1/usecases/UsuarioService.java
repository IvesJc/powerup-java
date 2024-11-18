package powerup.v1.usecases;

import powerup.v1.dtos.request.UsuarioRequestDto;
import powerup.v1.dtos.response.UsuarioResponseDto;
import powerup.v1.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    UsuarioRequestDto create(UsuarioResponseDto usuario);
    List<UsuarioRequestDto> getAll();
    UsuarioRequestDto getById(Integer id);
    UsuarioRequestDto update(Integer id, UsuarioResponseDto usuario);
    void delete(Integer id);
}
