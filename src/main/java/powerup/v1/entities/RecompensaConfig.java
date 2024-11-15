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
@Table(name = "recompensa_config")
public class RecompensaConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    @Column(name = "custo_pontos")
    private Integer custoPontos;

    @ManyToOne
    @JoinColumn(name = "recompensa_tipo_id", nullable = false)
    private RecompensaTipo recompensaTipo;
}
