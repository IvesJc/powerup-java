package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.RankingDto;
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
    public RankingDto create(Ranking ranking) {
        Ranking savedEntity = rankingRepository.save(ranking);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<RankingDto> getAll() {
        return rankingRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RankingDto getById(Integer id) {
        return rankingRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Ranking not found with id: " + id));
    }

    @Override
    public RankingDto update(Integer id, Ranking ranking) {
        if (!rankingRepository.existsById(id)) {
            throw new IdNotFoundException("Ranking not found with id: " + id);
        }
        ranking.setId(id);
        Ranking updatedEntity = rankingRepository.save(ranking);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!rankingRepository.existsById(id)) {
            throw new IdNotFoundException("Ranking not found with id: " + id);
        }
        rankingRepository.deleteById(id);
    }

    private RankingDto mapToDTO(Ranking ranking) {
        return RankingDto.builder()
                .id(ranking.getId())
                .nome(ranking.getNome())
                .build();
    }
}
