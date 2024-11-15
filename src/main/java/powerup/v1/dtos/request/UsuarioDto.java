package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record UsuarioDto(
        Integer id,
        String firebaseUid,
        String email,
        String nome,
        RankingDto ranking
) {
}
