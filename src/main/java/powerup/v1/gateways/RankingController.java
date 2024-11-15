package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.RankingDto;
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
    public ResponseEntity<RankingDto> create(@RequestBody Ranking ranking) {
        RankingDto createdRanking = rankingService.create(ranking);
        return new ResponseEntity<>(createdRanking, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RankingDto>> getAll() {
        List<RankingDto> rankingList = rankingService.getAll();
        return new ResponseEntity<>(rankingList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RankingDto> getById(@PathVariable Integer id) {
        RankingDto ranking = rankingService.getById(id);
        return new ResponseEntity<>(ranking, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RankingDto> update(@PathVariable Integer id, @RequestBody Ranking ranking) {
        RankingDto updatedRanking = rankingService.update(id, ranking);
        return new ResponseEntity<>(updatedRanking, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rankingService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
