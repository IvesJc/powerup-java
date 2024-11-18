package powerup.v1.usecases;

import powerup.v1.dtos.request.RankingRequestDto;
import powerup.v1.dtos.response.RankingResponseDto;
import powerup.v1.entities.Ranking;

import java.util.List;

public interface RankingService {
    RankingRequestDto create(RankingResponseDto ranking);
    List<RankingRequestDto> getAll();
    RankingRequestDto getById(Integer id);
    RankingRequestDto update(Integer id, RankingResponseDto ranking);
    void delete(Integer id);
}
