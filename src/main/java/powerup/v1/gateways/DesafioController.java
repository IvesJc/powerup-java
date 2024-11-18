package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.DesafioRequestDto;
import powerup.v1.dtos.response.DesafioResponseDto;
import powerup.v1.entities.Desafio;
import powerup.v1.usecases.DesafioService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/desafio/")
@Tag(name = "Desafio", description = "Endpoints destinados para a classe Desafio")
public class DesafioController {

    private final DesafioService desafioService;

    // Endpoint para criar um desafio
    @PostMapping
    public ResponseEntity<DesafioRequestDto> create(@RequestBody DesafioResponseDto desafio) {
        DesafioRequestDto createdDesafio = desafioService.create(desafio);
        return new ResponseEntity<>(createdDesafio, HttpStatus.CREATED);
    }

    // Endpoint para obter todos os desafios
    @GetMapping
    public ResponseEntity<List<DesafioRequestDto>> getAll() {
        List<DesafioRequestDto> desafioList = desafioService.getAll();
        return new ResponseEntity<>(desafioList, HttpStatus.OK);
    }

    // Endpoint para obter um desafio por ID
    @GetMapping("/{id}")
    public ResponseEntity<DesafioRequestDto> getById(@PathVariable Integer id) {
        DesafioRequestDto desafio = desafioService.getById(id);
        return new ResponseEntity<>(desafio, HttpStatus.OK);
    }

    // Endpoint para atualizar um desafio
    @PutMapping("/{id}")
    public ResponseEntity<DesafioRequestDto> update(@PathVariable Integer id, @RequestBody DesafioResponseDto desafio) {
        DesafioRequestDto updatedDesafio = desafioService.update(id, desafio);
        return new ResponseEntity<>(updatedDesafio, HttpStatus.OK);
    }

    // Endpoint para deletar um desafio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        desafioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
