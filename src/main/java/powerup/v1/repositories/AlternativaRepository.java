package powerup.v1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import powerup.v1.entities.Alternativa;
import powerup.v1.entities.Pergunta;

@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Long> {
}

