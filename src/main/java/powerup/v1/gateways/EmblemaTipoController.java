package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.EmblemaTipoDto;
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
    public ResponseEntity<EmblemaTipoDto> create(@RequestBody EmblemaTipo emblemaTipo) {
        EmblemaTipoDto createdEmblemaTipo = emblemaTipoService.create(emblemaTipo);
        return new ResponseEntity<>(createdEmblemaTipo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmblemaTipoDto>> getAll() {
        List<EmblemaTipoDto> emblemaTipoList = emblemaTipoService.getAll();
        return new ResponseEntity<>(emblemaTipoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmblemaTipoDto> getById(@PathVariable Integer id) {
        EmblemaTipoDto emblemaTipo = emblemaTipoService.getById(id);
        return new ResponseEntity<>(emblemaTipo, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmblemaTipoDto> update(@PathVariable Integer id, @RequestBody EmblemaTipo emblemaTipo) {
        EmblemaTipoDto updatedEmblemaTipo = emblemaTipoService.update(id, emblemaTipo);
        return new ResponseEntity<>(updatedEmblemaTipo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        emblemaTipoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
