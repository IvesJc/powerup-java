package powerup.v1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import powerup.v1.entities.Recompensa;
import powerup.v1.entities.RecompensaConfig;

@Repository
public interface RecompensaRepository extends JpaRepository<Recompensa, Integer> {
}

