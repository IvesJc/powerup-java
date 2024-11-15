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
@Table(name = "emblema_config")
public class EmblemaConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "emblema_tipo_id", nullable = false)
    private EmblemaTipo emblemaTipoId;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quizId;

}
