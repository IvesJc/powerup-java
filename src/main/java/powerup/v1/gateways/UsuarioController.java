package powerup.v1.gateways;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powerup.v1.dtos.request.UsuarioRequestDto;
import powerup.v1.dtos.response.UsuarioResponseDto;
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
    public ResponseEntity<UsuarioRequestDto> create(@RequestBody UsuarioResponseDto usuario) {
        UsuarioRequestDto createdUsuario = usuarioService.create(usuario);
        return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioRequestDto>> getAll() {
        List<UsuarioRequestDto> usuarioList = usuarioService.getAll();
        return new ResponseEntity<>(usuarioList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRequestDto> getById(@PathVariable Integer id) {
        UsuarioRequestDto usuario = usuarioService.getById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioRequestDto> update(@PathVariable Integer id, @RequestBody UsuarioResponseDto usuario) {
        UsuarioRequestDto updatedUsuario = usuarioService.update(id, usuario);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
