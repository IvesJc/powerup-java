package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record PermissaoDto(
        Integer id,
        String nome,
        String descricao
) {
}
