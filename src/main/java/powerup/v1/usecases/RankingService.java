package powerup.v1.usecases;

import powerup.v1.dtos.request.RankingRequestDto;
import powerup.v1.entities.Ranking;

import java.util.List;

public interface RankingService {
    RankingRequestDto create(Ranking ranking);
    List<RankingRequestDto> getAll();
    RankingRequestDto getById(Integer id);
    RankingRequestDto update(Integer id, Ranking ranking);
    void delete(Integer id);
}
