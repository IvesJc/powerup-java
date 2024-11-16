package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record EmblemaResponseDto(
        Integer usuario,
        Integer emblemaConfig
) {
}
