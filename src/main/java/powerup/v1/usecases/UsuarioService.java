package powerup.v1.usecases;

import powerup.v1.dtos.request.UsuarioRequestDto;
import powerup.v1.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    UsuarioRequestDto create(Usuario usuario);
    List<UsuarioRequestDto> getAll();
    UsuarioRequestDto getById(Integer id);
    UsuarioRequestDto update(Integer id, Usuario usuario);
    void delete(Integer id);
}
