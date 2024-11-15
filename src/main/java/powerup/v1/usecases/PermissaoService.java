package powerup.v1.usecases;

import powerup.v1.dtos.request.PerguntaDto;
import powerup.v1.dtos.request.PermissaoDto;
import powerup.v1.entities.Pergunta;
import powerup.v1.entities.Permissao;

import java.util.List;

public interface PermissaoService {
    PermissaoDto create(Permissao permissao);
    List<PermissaoDto> getAll();
    PermissaoDto getById(Integer id);
    PermissaoDto update(Integer id, Permissao permissao);
    void delete(Integer id);
}
