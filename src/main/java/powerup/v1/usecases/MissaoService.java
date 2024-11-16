package powerup.v1.usecases;

import powerup.v1.dtos.request.MissaoRequestDto;
import powerup.v1.entities.Missao;

import java.util.List;

public interface MissaoService {
    MissaoRequestDto create(Missao missao);
    List<MissaoRequestDto> getAll();
    MissaoRequestDto getById(Integer id);
    MissaoRequestDto update(Integer id, Missao missao);
    void delete(Integer id);
}
