package credit.core.service;

import credit.core.transformer.PoolDtoTransformer;
import credit.db.entity.Pool;
import credit.db.repository.PoolRepository;
import credit.model.PoolDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PoolService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final PoolRepository poolRepository;

    private final PoolDtoTransformer poolDtoTransformer;

    public PoolService(final PoolRepository poolRepository, final PoolDtoTransformer poolDtoTransformer) {
        this.poolRepository = poolRepository;
        this.poolDtoTransformer = poolDtoTransformer;
    }

    public PoolDto getPool(final String prefix, final Long id) {
        return poolDtoTransformer.generate(poolRepository.findOneByPrefixAndId(prefix, id));
    }

    public PoolDto createPool(final PoolDto poolDto) {
        Pool pool = poolRepository.saveAndFlush(poolDtoTransformer.generate(poolDto));
        return poolDtoTransformer.generate(pool);
    }
}
