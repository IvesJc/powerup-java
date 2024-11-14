package powerup.v1.usecases;

import powerup.v1.dtos.RankingDto;
import powerup.v1.entities.Ranking;

import java.util.List;
import java.util.Optional;

public interface RankingService {
    RankingDto create(Ranking ranking);

    Optional<RankingDto> getById(Long id);

    List<RankingDto> getAll();
}
