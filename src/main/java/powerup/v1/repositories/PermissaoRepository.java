package powerup.v1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import powerup.v1.entities.Pergunta;
import powerup.v1.entities.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {
}

