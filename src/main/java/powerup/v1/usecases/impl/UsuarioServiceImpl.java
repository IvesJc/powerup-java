package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.UsuarioRequestDto;
import powerup.v1.entities.Usuario;
import powerup.v1.repositories.UsuarioRepository;
import powerup.v1.usecases.UsuarioService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioRequestDto create(Usuario usuario) {
        Usuario savedEntity = usuarioRepository.save(usuario);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<UsuarioRequestDto> getAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioRequestDto getById(Integer id) {
        return usuarioRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Usuario not found with id: " + id));
    }

    @Override
    public UsuarioRequestDto update(Integer id, Usuario usuario) {
        if (!usuarioRepository.existsById(id)) {
            throw new IdNotFoundException("Usuario not found with id: " + id);
        }
        usuario.setId(id);
        Usuario updatedEntity = usuarioRepository.save(usuario);
        return mapToDTO(updatedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IdNotFoundException("Usuario not found with id: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    private UsuarioRequestDto mapToDTO(Usuario usuario) {
        return UsuarioRequestDto.builder()
                .id(usuario.getId())
                .firebaseUid(usuario.getFirebaseUid())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .ranking(usuario.getRanking().getId())
                .build();
    }
}
