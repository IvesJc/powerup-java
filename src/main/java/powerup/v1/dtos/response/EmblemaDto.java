package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record EmblemaDto(
        Integer id,
        Integer usuario,
        Integer emblemaConfig
) {
}
