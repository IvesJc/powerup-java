package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record EmblemaRequestDto(
        Integer id,
        Integer usuario,
        Integer emblemaConfig
) {
}
