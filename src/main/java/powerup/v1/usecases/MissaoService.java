package powerup.v1.usecases;

import powerup.v1.dtos.request.MissaoConfigDto;
import powerup.v1.dtos.request.MissaoDto;
import powerup.v1.entities.Missao;
import powerup.v1.entities.MissaoConfig;

import java.util.List;

public interface MissaoService {
    MissaoDto create(Missao missao);
    List<MissaoDto> getAll();
    MissaoDto getById(Integer id);
    MissaoDto update(Integer id, Missao missao);
    void delete(Integer id);
}
