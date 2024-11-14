package powerup.v1.dtos;

public record AlternativaDto(
        String descricao,
        boolean eCorreta,
        Long perguntaId
) {
}
