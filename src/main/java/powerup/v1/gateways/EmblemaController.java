package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.EmblemaDto;
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
    public ResponseEntity<EmblemaDto> create(@RequestBody Emblema emblema) {
        EmblemaDto createdEmblema = emblemaService.create(emblema);
        return new ResponseEntity<>(createdEmblema, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmblemaDto>> getAll() {
        List<EmblemaDto> emblemaList = emblemaService.getAll();
        return new ResponseEntity<>(emblemaList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmblemaDto> getById(@PathVariable Integer id) {
        EmblemaDto emblema = emblemaService.getById(id);
        return new ResponseEntity<>(emblema, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmblemaDto> update(@PathVariable Integer id, @RequestBody Emblema emblema) {
        EmblemaDto updatedEmblema = emblemaService.update(id, emblema);
        return new ResponseEntity<>(updatedEmblema, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        emblemaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
