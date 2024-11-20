package powerup.v1.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import powerup.v1.dtos.request.EmblemaRequestDto;
import powerup.v1.dtos.response.EmblemaResponseDto;
import powerup.v1.entities.Emblema;
import powerup.v1.entities.EmblemaConfig;
import powerup.v1.entities.Usuario;
import powerup.v1.repositories.EmblemaConfigRepository;
import powerup.v1.repositories.EmblemaRepository;
import powerup.v1.repositories.UsuarioRepository;
import powerup.v1.usecases.EmblemaService;
import powerup.v1.usecases.exception.IdNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmblemaServiceImpl implements EmblemaService {
    private final EmblemaRepository emblemaRepository;
    private final EmblemaConfigRepository emblemaConfigRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public EmblemaRequestDto create(EmblemaResponseDto emblema) {

        EmblemaConfig emblemaConfig = emblemaConfigRepository.findById(emblema.emblemaConfig()).orElseThrow(() -> new IdNotFoundException("EmblemaConfig not found with id: " + emblema.emblemaConfig()));

        Usuario usuario = usuarioRepository.findById(emblema.usuario()).orElseThrow(() -> new IdNotFoundException("Usuario not found with id: " + emblema.usuario()));

        Emblema newEmblema = Emblema.builder()
                .emblemaConfigId(emblemaConfig)
                .usuarioId(usuario).build();

        emblemaRepository.save(newEmblema);
        return mapToDTO(newEmblema);
    }

    @Override
    public List<EmblemaRequestDto> getAll() {
        return emblemaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmblemaRequestDto getById(Integer id) {
        return emblemaRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new IdNotFoundException("Emblema not found with id: " + id));
    }

    @Override
    public EmblemaRequestDto update(Integer id, EmblemaResponseDto emblema) {

        EmblemaConfig emblemaConfig = emblemaConfigRepository.findById(emblema.emblemaConfig()).orElseThrow(() -> new IdNotFoundException("EmblemaConfig not found with id: " + emblema.emblemaConfig()));

        Usuario usuario = usuarioRepository.findById(emblema.usuario()).orElseThrow(() -> new IdNotFoundException("Usuario not found with id: " + emblema.usuario()));


        Emblema updateEmblema = emblemaRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Emblema not found with id: " + id));

        updateEmblema.setEmblemaConfigId(emblemaConfig);
        updateEmblema.setUsuarioId(usuario);

        emblemaRepository.save(updateEmblema);
        return mapToDTO(updateEmblema);
    }

    @Override
    public void delete(Integer id) {
        if (!emblemaRepository.existsById(id)) {
            throw new IdNotFoundException("Emblema not found with id: " + id);
        }
        emblemaRepository.deleteById(id);
    }

    private EmblemaRequestDto mapToDTO(Emblema emblema) {
        return EmblemaRequestDto.builder()
                .id(emblema.getId())
                .usuario(emblema.getUsuarioId().getId())
                .emblemaConfig(emblema.getId())
                .build();
    }
}

