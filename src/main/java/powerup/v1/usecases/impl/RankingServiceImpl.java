package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.RankingRequestDto;
import powerup.v1.dtos.response.RankingResponseDto;
import powerup.v1.entities.Ranking;
import powerup.v1.repositories.RankingRepository;
import powerup.v1.usecases.RankingService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {
    private final RankingRepository rankingRepository;



    @Override
    public RankingRequestDto create(RankingResponseDto ranking) {
        Ranking savedEntity = Ranking.builder()
                .nome(ranking.nome())
                .build();
        rankingRepository.save(savedEntity);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<RankingRequestDto> getAll() {
        return rankingRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RankingRequestDto getById(Integer id) {
        return rankingRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Ranking not found with id: " + id));
    }

    @Override
    public RankingRequestDto update(Integer id, RankingResponseDto ranking) {

        Ranking updateRanking = rankingRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Ranking not found with id: " + id));

        updateRanking.setNome(ranking.nome());
        rankingRepository.save(updateRanking);
        return mapToDTO(updateRanking);
    }

    @Override
    public void delete(Integer id) {
        if (!rankingRepository.existsById(id)) {
            throw new IdNotFoundException("Ranking not found with id: " + id);
        }
        rankingRepository.deleteById(id);
    }

    private RankingRequestDto mapToDTO(Ranking ranking) {
        return RankingRequestDto.builder()
                .id(ranking.getId())
                .nome(ranking.getNome())
                .build();
    }
}
