package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record UsuarioPermissaoDto(
        Integer usuarioId,
        Integer permissaoId
) {
}
