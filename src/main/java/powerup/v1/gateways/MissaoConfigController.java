package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.MissaoConfigRequestDto;
import powerup.v1.dtos.response.MissaoConfigResponseDto;
import powerup.v1.entities.MissaoConfig;
import powerup.v1.usecases.MissaoConfigService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/missaoConfig/")
@Tag(name = "Missao Config", description = "Endpoints destinados para a classe Missao Config")
public class MissaoConfigController {

    private final MissaoConfigService missaoConfigService;
    @PostMapping
    public ResponseEntity<MissaoConfigRequestDto> create(@RequestBody MissaoConfigResponseDto missaoConfig) {
        MissaoConfigRequestDto createdMissaoConfig = missaoConfigService.create(missaoConfig);
        return new ResponseEntity<>(createdMissaoConfig, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MissaoConfigRequestDto>> getAll() {
        List<MissaoConfigRequestDto> missaoConfigList = missaoConfigService.getAll();
        return new ResponseEntity<>(missaoConfigList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissaoConfigRequestDto> getById(@PathVariable Integer id) {
        MissaoConfigRequestDto missaoConfig = missaoConfigService.getById(id);
        return new ResponseEntity<>(missaoConfig, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissaoConfigRequestDto> update(@PathVariable Integer id, @RequestBody MissaoConfigResponseDto missaoConfig) {
        MissaoConfigRequestDto updatedMissaoConfig = missaoConfigService.update(id, missaoConfig);
        return new ResponseEntity<>(updatedMissaoConfig, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        missaoConfigService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
