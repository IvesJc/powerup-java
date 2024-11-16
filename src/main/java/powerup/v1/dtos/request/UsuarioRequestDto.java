package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record UsuarioRequestDto(
        Integer id,
        String firebaseUid,
        String email,
        String nome,
        Integer ranking
) {
}
