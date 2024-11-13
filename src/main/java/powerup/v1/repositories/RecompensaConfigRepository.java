package powerup.v1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import powerup.v1.entities.RecompensaConfig;
import powerup.v1.entities.RecompensaTipo;

@Repository
public interface RecompensaConfigRepository extends JpaRepository<RecompensaConfig, Long> {
}

