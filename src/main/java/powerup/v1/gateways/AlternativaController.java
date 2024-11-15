package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.AlternativaDto;
import powerup.v1.entities.Alternativa;
import powerup.v1.usecases.impl.AlternativaServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/alternativa/")
@Tag(name = "Alternativa", description = "Endpoints destinados para a classe Alternativa")
public class AlternativaController {

    private final AlternativaServiceImpl alternativaService;

    // Endpoint para criar uma alternativa
    @PostMapping
    public ResponseEntity<AlternativaDto> create(@RequestBody Alternativa alternativa) {
        AlternativaDto createdAlternativa = alternativaService.create(alternativa);
        return new ResponseEntity<>(createdAlternativa, HttpStatus.CREATED);
    }

    // Endpoint para obter todas as alternativas
    @GetMapping
    public ResponseEntity<List<AlternativaDto>> getAll() {
        List<AlternativaDto> alternativaList = alternativaService.getAll();
        return new ResponseEntity<>(alternativaList, HttpStatus.OK);
    }

    // Endpoint para obter uma alternativa por ID
    @GetMapping("/{id}")
    public ResponseEntity<AlternativaDto> getById(@PathVariable Integer id) {
        AlternativaDto alternativa = alternativaService.getById(id);
        return new ResponseEntity<>(alternativa, HttpStatus.OK);
    }

    // Endpoint para atualizar uma alternativa
    @PutMapping("/{id}")
    public ResponseEntity<AlternativaDto> update(@PathVariable Integer id, @RequestBody Alternativa alternativa) {
        AlternativaDto updatedAlternativa = alternativaService.update(id, alternativa);
        return ResponseEntity.ok(updatedAlternativa);
    }

    // Endpoint para deletar uma alternativa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        alternativaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
