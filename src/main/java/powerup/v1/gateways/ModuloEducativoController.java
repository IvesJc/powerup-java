package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.ModuloEducativoDto;
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
    public ResponseEntity<ModuloEducativoDto> create(@RequestBody ModuloEducativo moduloEducativo) {
        ModuloEducativoDto createdModuloEducativo = moduloEducativoService.create(moduloEducativo);
        return new ResponseEntity<>(createdModuloEducativo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ModuloEducativoDto>> getAll() {
        List<ModuloEducativoDto> moduloEducativoList = moduloEducativoService.getAll();
        return new ResponseEntity<>(moduloEducativoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuloEducativoDto> getById(@PathVariable Integer id) {
        ModuloEducativoDto moduloEducativo = moduloEducativoService.getById(id);
        return new ResponseEntity<>(moduloEducativo, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuloEducativoDto> update(@PathVariable Integer id, @RequestBody ModuloEducativo moduloEducativo) {
        ModuloEducativoDto updatedModuloEducativo = moduloEducativoService.update(id, moduloEducativo);
        return new ResponseEntity<>(updatedModuloEducativo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        moduloEducativoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
