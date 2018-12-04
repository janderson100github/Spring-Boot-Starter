package credit.db.repository;

import credit.db.entity.Pool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoolRepository extends JpaRepository<Pool, Long> {

    Pool findOneByPrefixAndId(String prefix, Long id);
}
