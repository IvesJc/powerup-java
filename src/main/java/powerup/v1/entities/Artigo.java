package powerup.v1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "artigo")
public class Artigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String titulo;

    @NotNull
    private String subtitulo;

    @NotNull
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "thumb_link_id", nullable = false)
    private Link thumbLink;

    // TODO: REVIEW RELACAO
    @ManyToOne
    @JoinColumn(name = "MODULO_EDUCATIVO_ID", nullable = false)
    private ModuloEducativo moduloEducativoId;
}
