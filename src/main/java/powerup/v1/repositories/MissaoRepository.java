package powerup.v1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import powerup.v1.entities.Missao;
import powerup.v1.entities.MissaoConfig;

@Repository
public interface MissaoRepository extends JpaRepository<Missao, Integer> {
}

