package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.UsuarioRequestDto;
import powerup.v1.dtos.response.UsuarioResponseDto;
import powerup.v1.entities.Ranking;
import powerup.v1.entities.Usuario;
import powerup.v1.repositories.RankingRepository;
import powerup.v1.repositories.UsuarioRepository;
import powerup.v1.usecases.UsuarioService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RankingRepository rankingRepository;

    @Override
    public UsuarioRequestDto create(UsuarioResponseDto usuario) {

        Ranking ranking = rankingRepository.findById(usuario.ranking()).orElseThrow(() -> new IdNotFoundException("Ranking not found with id: " + usuario.ranking()));

        Usuario savedEntity = Usuario.builder()
                .nome(usuario.nome())
                .firebaseUid(usuario.firebaseUid())
                .email(usuario.email())
                .ranking(ranking)
                .build();
        usuarioRepository.save(savedEntity);
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
    public UsuarioRequestDto update(Integer id, UsuarioResponseDto usuario) {
        Ranking ranking = rankingRepository.findById(usuario.ranking()).orElseThrow(() -> new IdNotFoundException("Ranking not found with id: " + usuario.ranking()));

        Usuario updateUsuario = usuarioRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Usuario not found with id: " + id));

        updateUsuario.setNome(usuario.nome());
        updateUsuario.setEmail(usuario.email());
        updateUsuario.setFirebaseUid(usuario.firebaseUid());
        updateUsuario.setRanking(ranking);

        usuarioRepository.save(updateUsuario);
        return mapToDTO(updateUsuario);
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
