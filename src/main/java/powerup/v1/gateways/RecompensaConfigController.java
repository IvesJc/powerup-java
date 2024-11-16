package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.RecompensaConfigRequestDto;
import powerup.v1.entities.RecompensaConfig;
import powerup.v1.usecases.RecompensaConfigService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/recompensaConfig/")
@Tag(name = "Recompensa Config", description = "Endpoints destinados para a classe Recompensa Config")
public class RecompensaConfigController {

    private final RecompensaConfigService recompensaConfigService;

    @PostMapping
    public ResponseEntity<RecompensaConfigRequestDto> create(@RequestBody RecompensaConfig recompensaConfig) {
        RecompensaConfigRequestDto createdRecompensaConfig = recompensaConfigService.create(recompensaConfig);
        return new ResponseEntity<>(createdRecompensaConfig, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RecompensaConfigRequestDto>> getAll() {
        List<RecompensaConfigRequestDto> recompensaConfigList = recompensaConfigService.getAll();
        return new ResponseEntity<>(recompensaConfigList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecompensaConfigRequestDto> getById(@PathVariable Integer id) {
        RecompensaConfigRequestDto recompensaConfig = recompensaConfigService.getById(id);
        return new ResponseEntity<>(recompensaConfig, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecompensaConfigRequestDto> update(@PathVariable Integer id, @RequestBody RecompensaConfig recompensaConfig) {
        RecompensaConfigRequestDto updatedRecompensaConfig = recompensaConfigService.update(id, recompensaConfig);
        return new ResponseEntity<>(updatedRecompensaConfig, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        recompensaConfigService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
