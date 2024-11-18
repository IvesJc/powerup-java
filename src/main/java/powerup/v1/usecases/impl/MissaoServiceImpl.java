package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.MissaoRequestDto;
import powerup.v1.dtos.response.MissaoResponseDto;
import powerup.v1.entities.Missao;
import powerup.v1.entities.MissaoConfig;
import powerup.v1.entities.Usuario;
import powerup.v1.repositories.MissaoConfigRepository;
import powerup.v1.repositories.MissaoRepository;
import powerup.v1.repositories.UsuarioRepository;
import powerup.v1.usecases.MissaoService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissaoServiceImpl implements MissaoService {
    private final MissaoRepository missaoRepository;
    private final MissaoConfigRepository missaoConfigRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public MissaoRequestDto create(MissaoResponseDto missao) {

        MissaoConfig missaoConfig = missaoConfigRepository.findById(missao.missaoConfig()).orElseThrow(() -> new IdNotFoundException("Missao not found with id: " + missao.missaoConfig()));

        Usuario usuario = usuarioRepository.findById(missao.usuario()).orElseThrow(() -> new IdNotFoundException("Usuario not found with id: " + missao.usuario()));


        Missao savedEntity = Missao.builder()
                .recompensaPontos(missao.recompensaPontos())
                .status(missao.status())
                .missaoConfig(missaoConfig)
                .usuario(usuario).build();

        missaoRepository.save(savedEntity);
        return mapToDTO(savedEntity);
    }

    @Override
    public List<MissaoRequestDto> getAll() {
        return missaoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MissaoRequestDto getById(Integer id) {
        return missaoRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Missao not found with id: " + id));
    }

    @Override
    public MissaoRequestDto update(Integer id, MissaoResponseDto missao) {
        MissaoConfig missaoConfig = missaoConfigRepository.findById(missao.missaoConfig()).orElseThrow(() -> new IdNotFoundException("Missao not found with id: " + missao.missaoConfig()));

        Usuario usuario = usuarioRepository.findById(missao.usuario()).orElseThrow(() -> new IdNotFoundException("Usuario not found with id: " + missao.usuario()));

        Missao updateMissao = missaoRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Missao not found with id: " + id));

        updateMissao.setStatus(missao.status());
        updateMissao.setRecompensaPontos(missao.recompensaPontos());
        updateMissao.setMissaoConfig(missaoConfig);
        updateMissao.setUsuario(usuario);

        missaoRepository.save(updateMissao);
        return mapToDTO(updateMissao);
    }

    @Override
    public void delete(Integer id) {
        if (!missaoRepository.existsById(id)) {
            throw new IdNotFoundException("Missao not found with id: " + id);
        }
        missaoRepository.deleteById(id);
    }

    private MissaoRequestDto mapToDTO(Missao missao) {
        return MissaoRequestDto.builder()
                .id(missao.getId())
                .recompensaPontos(missao.getRecompensaPontos())
                .status(missao.getStatus())
                .missaoConfig(missao.getMissaoConfig().getId())
                .usuario(missao.getUsuario().getId())
                .build();
    }
}

