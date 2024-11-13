package powerup.v1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firebaseUid;
    private String email;
    private String nome;

    // TODO: REVIEW RELACAO
    @ManyToOne
    @JoinColumn(name = "ranking_id")
    private Ranking ranking;
}
