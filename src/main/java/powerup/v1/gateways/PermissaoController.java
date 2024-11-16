package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.PermissaoRequestDto;
import powerup.v1.entities.Permissao;
import powerup.v1.usecases.PermissaoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/permissao/")
@Tag(name = "Permissao", description = "Endpoints destinados para a classe Permissao")
public class PermissaoController {

    private final PermissaoService permissaoService;

    @PostMapping
    public ResponseEntity<PermissaoRequestDto> create(@RequestBody Permissao permissao) {
        PermissaoRequestDto createdPermissao = permissaoService.create(permissao);
        return new ResponseEntity<>(createdPermissao, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PermissaoRequestDto>> getAll() {
        List<PermissaoRequestDto> permissaoList = permissaoService.getAll();
        return new ResponseEntity<>(permissaoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissaoRequestDto> getById(@PathVariable Integer id) {
        PermissaoRequestDto permissao = permissaoService.getById(id);
        return new ResponseEntity<>(permissao, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissaoRequestDto> update(@PathVariable Integer id, @RequestBody Permissao permissao) {
        PermissaoRequestDto updatedPermissao = permissaoService.update(id, permissao);
        return new ResponseEntity<>(updatedPermissao, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        permissaoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
