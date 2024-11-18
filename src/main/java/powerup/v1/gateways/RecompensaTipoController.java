package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.RecompensaTipoRequestDto;
import powerup.v1.dtos.response.RecompensaTipoResponseDto;
import powerup.v1.entities.RecompensaTipo;
import powerup.v1.usecases.RecompensaTipoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/recompensaTipo")
@Tag(name = "Recompensa Tipo", description = "Endpoints destinados para a classe Recompensa Tipo")
public class RecompensaTipoController {

    private final RecompensaTipoService recompensaTipoService;

    @PostMapping
    public ResponseEntity<RecompensaTipoRequestDto> create(@RequestBody RecompensaTipoResponseDto recompensaTipo) {
        RecompensaTipoRequestDto createdRecompensaTipo = recompensaTipoService.create(recompensaTipo);
        return new ResponseEntity<>(createdRecompensaTipo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RecompensaTipoRequestDto>> getAll() {
        List<RecompensaTipoRequestDto> recompensaTipoList = recompensaTipoService.getAll();
        return new ResponseEntity<>(recompensaTipoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecompensaTipoRequestDto> getById(@PathVariable Integer id) {
        RecompensaTipoRequestDto recompensaTipo = recompensaTipoService.getById(id);
        return new ResponseEntity<>(recompensaTipo, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecompensaTipoRequestDto> update(@PathVariable Integer id, @RequestBody RecompensaTipoResponseDto recompensaTipo) {
        RecompensaTipoRequestDto updatedRecompensaTipo = recompensaTipoService.update(id, recompensaTipo);
        return new ResponseEntity<>(updatedRecompensaTipo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        recompensaTipoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
