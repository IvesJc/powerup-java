package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.RecompensaRequestDto;
import powerup.v1.dtos.response.RecompensaResponseDto;
import powerup.v1.entities.Recompensa;
import powerup.v1.entities.RecompensaConfig;
import powerup.v1.entities.Usuario;
import powerup.v1.repositories.RecompensaConfigRepository;
import powerup.v1.repositories.RecompensaRepository;
import powerup.v1.repositories.UsuarioRepository;
import powerup.v1.usecases.RecompensaService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecompensaServiceImpl implements RecompensaService {
    private final RecompensaRepository recompensaRepository;
    private final UsuarioRepository usuarioRepository;
    private final RecompensaConfigRepository recompensaConfigRepository;

    @Override
    public RecompensaRequestDto create(RecompensaResponseDto recompensa) {

        Usuario usuario = usuarioRepository.findById(recompensa.usuario()).orElseThrow(() -> new IdNotFoundException("Usuario not found with id: " + recompensa.usuario()));

        RecompensaConfig recompensaConfig = recompensaConfigRepository.findById(recompensa.recompensaConfig()).orElseThrow(() -> new IdNotFoundException("Recompensa Config not found"));

        Recompensa saveRecompensa = Recompensa.builder()
                .pontosUtilizados(recompensa.pontosUtilizados())
                .usuario(usuario)
                .recompensaConfig(recompensaConfig).build();

        recompensaRepository.save(saveRecompensa);
        return mapToDTO(saveRecompensa);
    }

    @Override
    public List<RecompensaRequestDto> getAll() {
        return recompensaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecompensaRequestDto getById(Integer id) {
        return recompensaRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Recompensa not found with id: " + id));
    }

    @Override
    public RecompensaRequestDto update(Integer id, RecompensaResponseDto recompensa) {

        Usuario usuario = usuarioRepository.findById(recompensa.usuario()).orElseThrow(() -> new IdNotFoundException("Usuario not found with id: " + recompensa.usuario()));

        RecompensaConfig recompensaConfig = recompensaConfigRepository.findById(recompensa.recompensaConfig()).orElseThrow(() -> new IdNotFoundException("Recompensa Config not found"));

        Recompensa updateRecompensa = recompensaRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Recompensa not found with id: " + id));

        updateRecompensa.setPontosUtilizados(recompensa.pontosUtilizados());
        updateRecompensa.setUsuario(usuario);
        updateRecompensa.setRecompensaConfig(recompensaConfig);

        recompensaRepository.save(updateRecompensa);
        return mapToDTO(updateRecompensa);
    }

    @Override
    public void delete(Integer id) {
        if (!recompensaRepository.existsById(id)) {
            throw new IdNotFoundException("Recompensa not found with id: " + id);
        }
        recompensaRepository.deleteById(id);
    }

    private RecompensaRequestDto mapToDTO(Recompensa recompensa) {
        return RecompensaRequestDto.builder()
                .id(recompensa.getId())
                .pontosUtilizados(recompensa.getPontosUtilizados())
                .usuario(recompensa.getUsuario().getId())
                .recompensaConfig(recompensa.getRecompensaConfig().getId())
                .build();
    }
}

