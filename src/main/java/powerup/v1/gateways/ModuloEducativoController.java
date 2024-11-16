package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.ModuloEducativoRequestDto;
import powerup.v1.entities.ModuloEducativo;
import powerup.v1.usecases.ModuloEducativoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/moduloEducativo/")
@Tag(name = "Modulo Educativo", description = "Endpoints destinados para a classe Modulo Educativo")
public class ModuloEducativoController {

    private final ModuloEducativoService moduloEducativoService;

    @PostMapping
    public ResponseEntity<ModuloEducativoRequestDto> create(@RequestBody ModuloEducativo moduloEducativo) {
        ModuloEducativoRequestDto createdModuloEducativo = moduloEducativoService.create(moduloEducativo);
        return new ResponseEntity<>(createdModuloEducativo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ModuloEducativoRequestDto>> getAll() {
        List<ModuloEducativoRequestDto> moduloEducativoList = moduloEducativoService.getAll();
        return new ResponseEntity<>(moduloEducativoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuloEducativoRequestDto> getById(@PathVariable Integer id) {
        ModuloEducativoRequestDto moduloEducativo = moduloEducativoService.getById(id);
        return new ResponseEntity<>(moduloEducativo, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuloEducativoRequestDto> update(@PathVariable Integer id, @RequestBody ModuloEducativo moduloEducativo) {
        ModuloEducativoRequestDto updatedModuloEducativo = moduloEducativoService.update(id, moduloEducativo);
        return new ResponseEntity<>(updatedModuloEducativo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        moduloEducativoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
