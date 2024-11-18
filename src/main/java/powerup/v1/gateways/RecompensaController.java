package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.RecompensaRequestDto;
import powerup.v1.dtos.response.RecompensaResponseDto;
import powerup.v1.entities.Recompensa;
import powerup.v1.usecases.RecompensaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/recompensa/")
@Tag(name = "Recompensa", description = "Endpoints destinados para a classe Recompensa")
public class RecompensaController {

    private final RecompensaService recompensaService;

    @PostMapping
    public ResponseEntity<RecompensaRequestDto> create(@RequestBody RecompensaResponseDto recompensa) {
        RecompensaRequestDto createdRecompensa = recompensaService.create(recompensa);
        return new ResponseEntity<>(createdRecompensa, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RecompensaRequestDto>> getAll() {
        List<RecompensaRequestDto> recompensaList = recompensaService.getAll();
        return new ResponseEntity<>(recompensaList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecompensaRequestDto> getById(@PathVariable Integer id) {
        RecompensaRequestDto recompensa = recompensaService.getById(id);
        return new ResponseEntity<>(recompensa, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecompensaRequestDto> update(@PathVariable Integer id, @RequestBody RecompensaResponseDto recompensa) {
        RecompensaRequestDto updatedRecompensa = recompensaService.update(id, recompensa);
        return new ResponseEntity<>(updatedRecompensa, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        recompensaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
