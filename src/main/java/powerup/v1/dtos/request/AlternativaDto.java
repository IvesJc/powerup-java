package powerup.v1.dtos.request;

public record AlternativaDto(
        Integer id,
        String descricao,
        // TODO: REVIEW
        Integer eCorreta,
        PerguntaDto pergunta
) {
}
