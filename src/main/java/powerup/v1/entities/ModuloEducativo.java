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
@Table(name = "modulo_educativo")
public class ModuloEducativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String titulo;

    @NotNull
    private String subtitulo;

    @NotNull
    private String descricao;

    @NotNull
    private Integer nivel;

    @ManyToOne
    @JoinColumn(name = "thumb_link_id")
    @NotNull
    private Link thumbLinkId;



}
