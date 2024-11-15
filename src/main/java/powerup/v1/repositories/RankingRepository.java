package powerup.v1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import powerup.v1.entities.MissaoConfig;
import powerup.v1.entities.Ranking;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Integer> {
}

