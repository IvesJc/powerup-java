package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record UsuarioDto(
        Integer id,
        String firebaseUid,
        String email,
        String nome,
        Integer ranking
) {
}
