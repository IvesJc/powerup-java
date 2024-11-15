package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record UsuarioPermissaoDto(
        Integer usuarioId,
        Integer permissaoId
) {
}
