package credit.db.repository;

import credit.db.entity.Pool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {Environment.class})
@ComponentScan({"credit.db"})
@EnableConfigurationProperties
@TestPropertySource(locations = "classpath:db-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PoolRepositoryTest {

    @Autowired
    private PoolRepository poolRepository;

    @Test
    public void crudTest() {
        String prefix = "prefix";
        Long id = 123l;
        Long total = 100l;
        String desc = "desc";
        String newDesc = "new desc";

        Pool pool = new Pool(prefix, id, total, desc);

        Pool poolSaved = poolRepository.saveAndFlush(pool);
        assertEquals(new Long(1l), poolSaved.getGid());
        assertEquals(id, poolSaved.getId());

        poolSaved.setDescription(newDesc);
        poolSaved = poolRepository.saveAndFlush(poolSaved);
        assertEquals(newDesc, poolSaved.getDescription());

        poolRepository.delete(poolSaved);

        assertEquals(0, poolRepository.count());
    }

    @Test
    public void findOneByPrefixAndId() {
        Pool pool = new Pool("prefix", 123l, 100l, "desc");
        poolRepository.saveAndFlush(pool);

        Pool foundPool = poolRepository.findOneByPrefixAndId(pool.getPrefix(), pool.getId());
        assertEquals(pool.getPrefix(), foundPool.getPrefix());
        assertEquals(pool.getId(), foundPool.getId());
        assertEquals(pool.getDescription(), foundPool.getDescription());
    }
}
