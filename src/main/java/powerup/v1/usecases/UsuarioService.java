package powerup.v1.usecases;

import powerup.v1.dtos.request.ModuloEducativoDto;
import powerup.v1.dtos.request.UsuarioDto;
import powerup.v1.entities.ModuloEducativo;
import powerup.v1.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    UsuarioDto create(Usuario usuario);
    List<UsuarioDto> getAll();
    UsuarioDto getById(Integer id);
    UsuarioDto update(Integer id, Usuario usuario);
    void delete(Integer id);
}
