package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record PermissaoDto(
        Integer id,
        String nome,
        String descricao
) {
}
