package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.RankingRequestDto;
import powerup.v1.entities.Ranking;
import powerup.v1.usecases.RankingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/ranking/")
@Tag(name = "Ranking", description = "Endpoints destinados para a classe Ranking")
public class RankingController {

    private final RankingService rankingService;

    @PostMapping
    public ResponseEntity<RankingRequestDto> create(@RequestBody Ranking ranking) {
        RankingRequestDto createdRanking = rankingService.create(ranking);
        return new ResponseEntity<>(createdRanking, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RankingRequestDto>> getAll() {
        List<RankingRequestDto> rankingList = rankingService.getAll();
        return new ResponseEntity<>(rankingList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RankingRequestDto> getById(@PathVariable Integer id) {
        RankingRequestDto ranking = rankingService.getById(id);
        return new ResponseEntity<>(ranking, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RankingRequestDto> update(@PathVariable Integer id, @RequestBody Ranking ranking) {
        RankingRequestDto updatedRanking = rankingService.update(id, ranking);
        return new ResponseEntity<>(updatedRanking, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rankingService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
