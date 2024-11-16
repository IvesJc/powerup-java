package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record UsuarioResponseDto(
        String firebaseUid,
        String email,
        String nome,
        Integer ranking
) {
}
