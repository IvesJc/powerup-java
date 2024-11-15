package powerup.v1.usecases;

import powerup.v1.dtos.request.EmblemaDto;
import powerup.v1.dtos.request.EmblemaTipoDto;
import powerup.v1.dtos.request.UsuarioDto;
import powerup.v1.entities.Emblema;
import powerup.v1.entities.EmblemaTipo;
import powerup.v1.entities.Usuario;

import java.util.List;

public interface EmblemaService {
    EmblemaDto create(Emblema emblema);
    List<EmblemaDto> getAll();
    EmblemaDto getById(Integer id);
    EmblemaDto update(Integer id, Emblema emblema);
    void delete(Integer id);
}
