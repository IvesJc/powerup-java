package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record UsuarioPermissaoRequestDto(
        Integer usuarioId,
        Integer permissaoId
) {
}
