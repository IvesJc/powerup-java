package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.PerguntaRequestDto;
import powerup.v1.dtos.response.PerguntaResponseDto;
import powerup.v1.entities.Pergunta;
import powerup.v1.usecases.PerguntaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/pergunta/")
@Tag(name = "Pergunta", description = "Endpoints destinados para a classe Pergunta")
public class PerguntaController {

    private final PerguntaService perguntaService;

    @PostMapping
    public ResponseEntity<PerguntaRequestDto> create(@RequestBody PerguntaResponseDto pergunta) {
        PerguntaRequestDto createdPergunta = perguntaService.create(pergunta);
        return new ResponseEntity<>(createdPergunta, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PerguntaRequestDto>> getAll() {
        List<PerguntaRequestDto> perguntaList = perguntaService.getAll();
        return new ResponseEntity<>(perguntaList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerguntaRequestDto> getById(@PathVariable Integer id) {
        PerguntaRequestDto pergunta = perguntaService.getById(id);
        return new ResponseEntity<>(pergunta, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerguntaRequestDto> update(@PathVariable Integer id, @RequestBody PerguntaResponseDto pergunta) {
        PerguntaRequestDto updatedPergunta = perguntaService.update(id, pergunta);
        return new ResponseEntity<>(updatedPergunta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        perguntaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
