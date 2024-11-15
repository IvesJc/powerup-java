package powerup.v1.usecases;

import powerup.v1.dtos.request.RankingDto;
import powerup.v1.entities.Ranking;

import java.util.List;
import java.util.Optional;

public interface RankingService {
    RankingDto create(Ranking ranking);
    List<RankingDto> getAll();
    RankingDto getById(Integer id);
    RankingDto update(Integer id, Ranking ranking);
    void delete(Integer id);
}
