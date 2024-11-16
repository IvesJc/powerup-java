package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.MissaoRequestDto;
import powerup.v1.entities.Missao;
import powerup.v1.usecases.impl.MissaoServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/missao/")
@Tag(name = "Missao", description = "Endpoints destinados para a classe Missao")
public class MissaoController {

    private final MissaoServiceImpl missaoService;

    // Endpoint para criar uma missão
    @PostMapping
    public ResponseEntity<MissaoRequestDto> create(@RequestBody Missao missao) {
        MissaoRequestDto createdMissao = missaoService.create(missao);
        return new ResponseEntity<>(createdMissao, HttpStatus.CREATED);
    }

    // Endpoint para obter todas as missões
    @GetMapping
    public ResponseEntity<List<MissaoRequestDto>> getAll() {
        List<MissaoRequestDto> missaoList = missaoService.getAll();
        return new ResponseEntity<>(missaoList, HttpStatus.OK);
    }

    // Endpoint para obter uma missão por ID
    @GetMapping("/{id}")
    public ResponseEntity<MissaoRequestDto> getById(@PathVariable Integer id) {
        MissaoRequestDto missao = missaoService.getById(id);
        return new ResponseEntity<>(missao, HttpStatus.OK);
    }

    // Endpoint para atualizar uma missão
    @PutMapping("/{id}")
    public ResponseEntity<MissaoRequestDto> update(@PathVariable Integer id, @RequestBody Missao missao) {
        MissaoRequestDto updatedMissao = missaoService.update(id, missao);
        return new ResponseEntity<>(updatedMissao, HttpStatus.OK);
    }

    // Endpoint para deletar uma missão
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        missaoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
