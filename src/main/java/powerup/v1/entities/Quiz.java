package powerup.v1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    @NotNull
    private String categoria;

    @NotNull
    @Column(name = "nota_minima")
    private Integer notaMinima;

    @ManyToOne
    @JoinColumn(name = "modulo_educativo_id", nullable = false)
    private ModuloEducativo moduloEducativo;
}
