package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.EmblemaRequestDto;
import powerup.v1.entities.Emblema;
import powerup.v1.usecases.EmblemaService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/emblema/")
@Tag(name = "Emblema", description = "Endpoints destinados para a classe Emblema")
public class EmblemaController {
    
    private final EmblemaService emblemaService;

    @PostMapping
    public ResponseEntity<EmblemaRequestDto> create(@RequestBody Emblema emblema) {
        EmblemaRequestDto createdEmblema = emblemaService.create(emblema);
        return new ResponseEntity<>(createdEmblema, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmblemaRequestDto>> getAll() {
        List<EmblemaRequestDto> emblemaList = emblemaService.getAll();
        return new ResponseEntity<>(emblemaList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmblemaRequestDto> getById(@PathVariable Integer id) {
        EmblemaRequestDto emblema = emblemaService.getById(id);
        return new ResponseEntity<>(emblema, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmblemaRequestDto> update(@PathVariable Integer id, @RequestBody Emblema emblema) {
        EmblemaRequestDto updatedEmblema = emblemaService.update(id, emblema);
        return new ResponseEntity<>(updatedEmblema, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        emblemaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
