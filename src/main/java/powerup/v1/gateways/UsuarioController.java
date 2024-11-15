package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.UsuarioDto;
import powerup.v1.entities.Usuario;
import powerup.v1.usecases.UsuarioService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/powerup/usuario")
@Tag(name = "Usuario", description = "Endpoints destinados para a classe Usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> create(@RequestBody Usuario usuario) {
        UsuarioDto createdUsuario = usuarioService.create(usuario);
        return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAll() {
        List<UsuarioDto> usuarioList = usuarioService.getAll();
        return new ResponseEntity<>(usuarioList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getById(@PathVariable Integer id) {
        UsuarioDto usuario = usuarioService.getById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        UsuarioDto updatedUsuario = usuarioService.update(id, usuario);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
