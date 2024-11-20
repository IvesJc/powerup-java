package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.EmblemaTipoRequestDto;
import powerup.v1.dtos.response.EmblemaTipoResponseDto;
import powerup.v1.entities.EmblemaTipo;
import powerup.v1.usecases.EmblemaTipoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/emblemaTipo/")
@Tag(name = "Emblema Tipo", description = "Endpoints destinados para a classe Emblema Tipo")
public class EmblemaTipoController {

    private final EmblemaTipoService emblemaTipoService;
    
    @PostMapping
    public ResponseEntity<EmblemaTipoRequestDto> create(@RequestBody EmblemaTipoResponseDto emblemaTipo) {
        EmblemaTipoRequestDto createdEmblemaTipo = emblemaTipoService.create(emblemaTipo);
        return new ResponseEntity<>(createdEmblemaTipo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmblemaTipoRequestDto>> getAll() {
        List<EmblemaTipoRequestDto> emblemaTipoList = emblemaTipoService.getAll();
        return new ResponseEntity<>(emblemaTipoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmblemaTipoRequestDto> getById(@PathVariable Integer id) {
        EmblemaTipoRequestDto emblemaTipo = emblemaTipoService.getById(id);
        return new ResponseEntity<>(emblemaTipo, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmblemaTipoRequestDto> update(@PathVariable Integer id, @RequestBody EmblemaTipoResponseDto emblemaTipo) {
        EmblemaTipoRequestDto updatedEmblemaTipo = emblemaTipoService.update(id, emblemaTipo);
        return new ResponseEntity<>(updatedEmblemaTipo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        emblemaTipoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
